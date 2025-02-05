package com.arifrhm.warehouse.service.domain;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.domain.dto.create.CreateStockCommand;
import com.arifrhm.warehouse.service.domain.entity.Product;
import com.arifrhm.warehouse.service.domain.entity.Stock;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.event.StockCreatedEvent;
import com.arifrhm.warehouse.service.domain.exception.WarehouseDomainException;
import com.arifrhm.warehouse.service.domain.mapper.WarehouseDataMapper;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockCreatedEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.repository.ProductRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.StockRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class StockCreateHelper {

    private final WarehouseDomainService warehouseDomainService;
    private final StockRepository stockRepository;
    private final WarehouseRepository warehouseRepository;
    private final WarehouseDataMapper warehouseDataMapper;
    private final StockCreatedEventPublisher stockCreatedEventPublisher;
    private final ProductRepository productRepository;

    public StockCreateHelper(WarehouseDomainService warehouseDomainService,
                             StockRepository stockRepository,
                             WarehouseRepository warehouseRepository,
                             ProductRepository productRepository,
                             WarehouseDataMapper warehouseDataMapper,
                             StockCreatedEventPublisher stockCreatedEventPublisher) {
        this.warehouseDomainService = warehouseDomainService;
        this.stockRepository = stockRepository;
        this.warehouseRepository = warehouseRepository;
        this.warehouseDataMapper = warehouseDataMapper;
        this.productRepository = productRepository;
        this.stockCreatedEventPublisher = stockCreatedEventPublisher;
    }

    @Transactional
    public StockCreatedEvent processStockCreation(CreateStockCommand createStockCommand) {
        Warehouse warehouse = getWarehouseById(new WarehouseId(createStockCommand.getWarehouseId()));
        Product product = getProductById(new ProductId(createStockCommand.getProductId()));

        Stock stock = warehouseDataMapper.createStockfromCreateStockCommand(createStockCommand);
        validateStockDoesNotExist(stock);

        StockCreatedEvent stockCreatedEvent = warehouseDomainService.validateAndInitializeStock(stock, warehouse, product, stockCreatedEventPublisher);
        saveStock(stock);

        Integer productTotalQuantity = stockRepository.getProductTotalQuantity(product.getId());
        productTotalQuantity = productTotalQuantity != null ? productTotalQuantity : 0;
        stockCreatedEvent.setProductTotalQuantity(productTotalQuantity);


        return stockCreatedEvent;
    }

    private Warehouse getWarehouseById(WarehouseId warehouseId) {
        return warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new WarehouseDomainException("Warehouse not found with id: " + warehouseId.getValue().toString()));
    }

    private Product getProductById(ProductId productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new WarehouseDomainException("Product not found with id: " + productId.getValue().toString()));
    }

    private void validateStockDoesNotExist(Stock stock) {
        Optional<Stock> existingStock = stockRepository.findByWarehouseIdAndProductId(stock.getWarehouseId(), stock.getProductId());
        if (existingStock.isPresent()) {
            log.warn("Stock already exists for product id: {} in warehouse id: {}", stock.getProductId().getValue(), stock.getWarehouseId().getValue());
            throw new WarehouseDomainException("Stock already exists for this product in the specified warehouse.");
        }
    }

    private void saveStock(Stock stock) {
        Stock savedStock = stockRepository.save(stock);
        if (savedStock == null) {
            log.error("Could not save stock with product id: {} in warehouse id: {}", stock.getProductId().getValue(), stock.getWarehouseId().getValue());
            throw new WarehouseDomainException("Failed to save stock.");
        }
        log.info("Stock is saved with id: {}", savedStock.getId().getValue());
    }
}
