package com.arifrhm.warehouse.service.domain.ports.output.repository;

import com.arifrhm.domain.valueobject.OrderId;
import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.domain.entity.OrderStockMutation;

import java.util.List;
import java.util.Optional;

public interface OrderStockMutationRepository {

    Optional<OrderStockMutation> findByWarehouseIdAndProductId(WarehouseId warehouseId, ProductId productId);

    OrderStockMutation save(OrderStockMutation orderStockMutation);

    Optional<List<OrderStockMutation>> findByOrderId(OrderId orderId);

    void updateStatusStockMutation(OrderStockMutation orderStockMutation);
}
