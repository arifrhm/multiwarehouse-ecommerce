package com.arifrhm.warehouse.service.domain;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.domain.entity.OrderStockMutation;
import com.arifrhm.warehouse.service.domain.entity.Product;
import com.arifrhm.warehouse.service.domain.entity.Stock;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.exception.WarehouseDomainException;
import com.arifrhm.warehouse.service.domain.ports.output.repository.OrderStockMutationRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.ProductRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.StockRepository;
import com.arifrhm.warehouse.service.domain.ports.output.repository.WarehouseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class WarehouseSagaHelper {

    private final WarehouseRepository warehouseRepository;
    private final StockRepository stockRepository;
    private final ProductRepository productRepository;
    private final OrderStockMutationRepository orderStockMutationRepository;

    public WarehouseSagaHelper(WarehouseRepository warehouseRepository, StockRepository stockRepository, ProductRepository productRepository, OrderStockMutationRepository orderStockMutationRepository) {
        this.warehouseRepository = warehouseRepository;
        this.stockRepository = stockRepository;
        this.productRepository = productRepository;
        this.orderStockMutationRepository = orderStockMutationRepository;
    }

    public Warehouse findWarehouse(String warehouseId) {
        return warehouseRepository.findById(new WarehouseId(UUID.fromString(warehouseId)))
                .orElseThrow(() -> new WarehouseDomainException("Warehouse with id " + warehouseId + " not found!"));
    }
    public Product findProduct(String productId) {
        return productRepository.findById(new ProductId(UUID.fromString(productId)))
                .orElseThrow(() -> new WarehouseDomainException("Product with id " + productId + " not found!"));
    }

    public Optional<Stock> findStock(String warehouseId, String productId) {
        return stockRepository.findByWarehouseIdAndProductId(new WarehouseId(UUID.fromString(warehouseId)),new ProductId(UUID.fromString(productId)) );
    }

    // findByProductIdIn
    public Optional<List<Stock>> findByProductIdIn(List<ProductId> productIds){
        return stockRepository.findByProductIdIn(productIds);
    }


    public void saveStock(Stock stock) {
        stockRepository.save(stock);
    }

    public Integer getProductTotalQuantity(ProductId productId) {
        return stockRepository.getProductTotalQuantity(productId);
    }

    public void saveOrderStockMutation(OrderStockMutation orderStockMutation) {
        orderStockMutationRepository.save(orderStockMutation);
    }
}
