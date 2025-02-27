package com.arifrhm.warehouse.service.domain;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.domain.dto.create.CreateUpdateStockCommand;
import com.arifrhm.warehouse.service.domain.entity.Product;
import com.arifrhm.warehouse.service.domain.entity.Stock;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.event.StockCreatedEvent;
import com.arifrhm.warehouse.service.domain.event.StockEvent;
import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;
import com.arifrhm.warehouse.service.domain.exception.WarehouseDomainException;
import com.arifrhm.warehouse.service.domain.mapper.WarehouseDataMapper;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockCreatedEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockUpdatedEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.repository.ProductRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.StockRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Component
public class StockUpdateHelper {

    private final WarehouseDomainService warehouseDomainService;
    private final StockRepository stockRepository;
    private final WarehouseDataMapper warehouseDataMapper;
    private final StockUpdatedEventPublisher stockUpdatedEventPublisher;
    private final WarehouseRepository warehouseRepository;
    private final ProductRepository productRepository;
    private final StockCreatedEventPublisher stockCreatedEventPublisher;

    public StockUpdateHelper(WarehouseDomainService warehouseDomainService,
                             StockRepository stockRepository,
                             WarehouseRepository warehouseRepository,
                             ProductRepository productRepository,
                             WarehouseDataMapper warehouseDataMapper,
                             StockCreatedEventPublisher stockCreatedEventPublisher,
                             StockUpdatedEventPublisher stockUpdatedEventPublisher) {
        this.warehouseDomainService = warehouseDomainService;
        this.stockRepository = stockRepository;
        this.warehouseRepository = warehouseRepository;
        this.productRepository = productRepository;
        this.warehouseDataMapper = warehouseDataMapper;
        this.stockCreatedEventPublisher = stockCreatedEventPublisher;
        this.stockUpdatedEventPublisher = stockUpdatedEventPublisher;
    }

    @Transactional
    public StockEvent processStockUpdate(CreateUpdateStockCommand updateStockCommand) {

        // Validate warehouse and product existence
        Optional<Warehouse> warehouse = warehouseRepository.findById(new WarehouseId(updateStockCommand.getWarehouseId()));
        if (!warehouse.isPresent()) {
            log.warn("Warehouse not found with id: {}", updateStockCommand.getWarehouseId());
            throw new WarehouseDomainException("Warehouse not found.");
        }

        Optional<Product> product = productRepository.findById(new ProductId(updateStockCommand.getProductId()));
        if (!product.isPresent()) {
            log.warn("Product not found with id: {}", updateStockCommand.getProductId());
            throw new WarehouseDomainException("Product not found.");
        }

        // Check if stock exists (findByWarehouseIdAndProductId)
        Optional<Stock> existingStock = stockRepository.findByWarehouseIdAndProductId(
                new WarehouseId(updateStockCommand.getWarehouseId()),
                new ProductId(updateStockCommand.getProductId())
        );

        if (!existingStock.isPresent()) {
            // Create new stock if it doesn't exist
            Stock stock = warehouseDataMapper.createStockFromCreateUpdateStockCommand(updateStockCommand);
            StockCreatedEvent stockCreatedEvent = warehouseDomainService.validateAndInitializeStock(stock, warehouse.get(), product.get(), stockCreatedEventPublisher);
            saveStock(stock);

            Integer productTotalQuantity = stockRepository.getProductTotalQuantity(new ProductId(updateStockCommand.getProductId()));
            stockCreatedEvent.setProductTotalQuantity(productTotalQuantity);

            return stockCreatedEvent;  // Return the created event
        } else {
            // Update stock if it exists
            StockUpdatedEvent stockUpdatedEvent = warehouseDomainService.validateAndPatchStock(
                    existingStock.get(),updateStockCommand.getQuantity(), stockUpdatedEventPublisher
            );
            saveStock(existingStock.get());

            Integer productTotalQuantity = stockRepository.getProductTotalQuantity(new ProductId(updateStockCommand.getProductId()));
            productTotalQuantity = productTotalQuantity != null ? productTotalQuantity : 0;
            stockUpdatedEvent.setProductTotalQuantity(productTotalQuantity);

            return stockUpdatedEvent;  // Return the updated event
        }
    }


    private void saveStock(Stock stock) {
        Stock savedStock = stockRepository.save(stock);
        if (savedStock == null) {
            log.error("Could not save stock with product id: {} in warehouse id: {}", stock.getProductId().getValue(), stock.getWarehouseId().getValue());
            throw new WarehouseDomainException("Failed to save updated stock.");
        }
        log.info("Stock is saved with id: {}", savedStock.getId().getValue());
    }
}
