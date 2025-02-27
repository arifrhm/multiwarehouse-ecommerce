package com.arifrhm.warehouse.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.domain.valueobject.OrderId;
import com.arifrhm.warehouse.service.domain.entity.*;
import com.arifrhm.warehouse.service.domain.event.*;
import com.arifrhm.warehouse.service.domain.valueobject.StreetAddress;

import java.util.Optional;

public interface WarehouseDomainService {

    WarehouseCreatedEvent validateAndInitializeWarehouse(Warehouse warehouse, DomainEventPublisher<WarehouseCreatedEvent> publisher);
    WarehouseUpdatedEvent validateAndPatchWarehouse(Warehouse warehouse, String newName, StreetAddress newStreetAddress, DomainEventPublisher<WarehouseUpdatedEvent> publisher);

    //    void deleteWarehouse(Warehouse warehouse);
    //    void assignWarehouseAdmin(Warehouse warehouse, User user);

    StockCreatedEvent validateAndInitializeStock(Stock stock, Warehouse warehouse, Product product, DomainEventPublisher<StockCreatedEvent> publisher);
    StockUpdatedEvent validateAndPatchStock(Stock stock, int quantity, DomainEventPublisher<StockUpdatedEvent> publisher);

    StockTransferredEvent transferStock(Warehouse fromWarehouse, Warehouse toWarehouse, Stock fromStock, Optional<Stock> toStock, Product product, int quantity, DomainEventPublisher<StockTransferredEvent> publisher);

    OrderStockMutation validateAndInitiateOrderStockMutation(OrderId orderId, Stock stock, Integer quantity);

    void stockMutationPaid(OrderStockMutation orderStockMutation);
    void stockMutationCancelled(OrderStockMutation orderStockMutation);

    void createUser(User user);

}
