package com.arifrhm.order.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.order.service.domain.entity.Stock;

import java.util.List;
import java.util.Optional;

public interface StockRepository {
    Stock save(Stock stock);

    Optional<Stock> findByWarehouseIdAndProductId(WarehouseId warehouseId, ProductId productId);

    List<Stock> findByWarehouseId(WarehouseId warehouseId);

    void delete(Stock stock);


    Optional<List<Stock>> findByProductIdIn(List<ProductId> productIds);

}
