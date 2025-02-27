package com.arifrhm.warehouse.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.domain.valueobject.*;
import com.arifrhm.warehouse.service.domain.entity.*;
import com.arifrhm.warehouse.service.domain.event.*;
import com.arifrhm.warehouse.service.domain.exception.WarehouseDomainException;
import com.arifrhm.warehouse.service.domain.valueobject.StatusStockMutation;
import com.arifrhm.warehouse.service.domain.valueobject.StreetAddress;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class WarehouseDomainServiceImpl implements WarehouseDomainService{

    private static final String UTC = "UTC";

    @Override
    public WarehouseCreatedEvent validateAndInitializeWarehouse(Warehouse warehouse,
                                                                DomainEventPublisher<WarehouseCreatedEvent> publisher) {
        warehouse.validateInitialWarehouse();
        warehouse.initializeWarehouse();
        log.info("Warehouse with id: {} is created", warehouse.getId().getValue());
        return new WarehouseCreatedEvent(warehouse, ZonedDateTime.now(ZoneId.of(UTC)), publisher);
    }

    @Override
    public WarehouseUpdatedEvent validateAndPatchWarehouse(Warehouse warehouse,
                                                           String newName,
                                                           StreetAddress newStreetAddress,
                                                           DomainEventPublisher<WarehouseUpdatedEvent> publisher) {
        warehouse.validateWarehouse();
        warehouse.updateWarehouse(newName, newStreetAddress);
        log.info("Warehouse with id: {} is updated", warehouse.getId().getValue());
        return new WarehouseUpdatedEvent(warehouse, ZonedDateTime.now(ZoneId.of(UTC)), publisher);
    }

//    @Override
//    public void deleteWarehouse(Warehouse warehouse) {
//        warehouse.initDelete();
//        log.info("Warehouse with id: {} is deleted", warehouse.getId().getValue());
//    }
//
//    @Override
//    public void assignWarehouseAdmin(Warehouse warehouse, User user) {
//        validateUserAsWarehouseAdmin(user);
//        warehouse.addAssignedAdmin(user);
//
//        log.info("User with id: {} has been assigned as Warehouse Admin to warehouse with id: {}",
//                user.getId().getValue(), warehouse.getId().getValue());
//    }


    @Override
    public StockCreatedEvent validateAndInitializeStock(Stock stock,
                                                        Warehouse warehouse,
                                                        Product product,
                                                        DomainEventPublisher<StockCreatedEvent> publisher) {
        stock.validateStock(true);
        stock.initializeStock(new WarehouseId(warehouse.getId().getValue()), new ProductId(product.getId().getValue()));

        log.info("Stock with id: {} has been created for product id: {}", stock.getId().getValue(), stock.getProductId());

        return new StockCreatedEvent(stock, warehouse.getName(), warehouse.getStreetAddress().getLatitude(), warehouse.getStreetAddress().getLongitude(), product.getName(), ZonedDateTime.now(ZoneId.of(UTC)), publisher);
    }

    @Override
    public StockUpdatedEvent validateAndPatchStock(Stock stock, int quantity, DomainEventPublisher<StockUpdatedEvent> publisher) {
        stock.validateStock(false);

        log.info("reducing stock for product id: {} with quantity: {} from current quantity: {} to new quantity: {}",
                stock.getProductId().getValue().toString(), quantity, stock.getQuantity(), stock.getQuantity() + quantity);

        stock.updateQuantity(quantity);

        log.info("Stock for product id: {} has been updated with quantity: {}",
                stock.getProductId().getValue().toString(), stock.getQuantity());

        return new StockUpdatedEvent(stock, quantity, ZonedDateTime.now(ZoneId.of(UTC)), publisher);
    }


    @Override
    public OrderStockMutation validateAndInitiateOrderStockMutation(OrderId orderId, Stock stock, Integer quantity) {
        log.info("Validating order stock mutation for order id: {} with product id: {} and quantity: {}", orderId.getValue(), stock.getProductId().getValue(), quantity);
        OrderStockMutation orderStockMutation = OrderStockMutation.builder()
                .orderStockMutationId(new OrderStockMutationId(UUID.randomUUID()))
                .orderId(orderId)
                .warehouseId(stock.getWarehouseId())
                .productId(stock.getProductId())
                .quantity(quantity)
                .statusStockMutation(StatusStockMutation.PENDING)
                .build();
        orderStockMutation.validateStock();
        return orderStockMutation;
    }

    @Override
    public void stockMutationPaid(OrderStockMutation orderStockMutation) {
        orderStockMutation.updateStatusStockMutation(StatusStockMutation.COMPLETED);
    }

    @Override
    public void stockMutationCancelled(OrderStockMutation orderStockMutation) {
        log.info("Stock mutation for order id: {} with product id: {} is cancelled", orderStockMutation.getOrderId().getValue(), orderStockMutation.getProductId().getValue());
        orderStockMutation.updateStatusStockMutation(StatusStockMutation.CANCELED);
    }

    @Override
    public StockTransferredEvent transferStock(Warehouse fromWarehouse,
                                               Warehouse toWarehouse,
                                               Stock fromStock,
                                               Optional<Stock> toStock,
                                               Product product,
                                               int quantity,
                                               DomainEventPublisher<StockTransferredEvent> publisher) {

        fromWarehouse.validateWarehouse();
        toWarehouse.validateWarehouse();

        validateStockTransfer(fromWarehouse, toWarehouse, fromStock, quantity);
        fromStock.deductStock(quantity);

        if (!toStock.isPresent()){
            toWarehouse.initializeStock(product.getId(), quantity);
        }else{
            toStock.get().addStock(quantity);
        }

//        toWarehouse.addOrCreateStock(product.getId(), quantity);

        fromStock.recordStockTransfer(fromWarehouse.getId(), toWarehouse.getId(), product.getId(), quantity, String.valueOf(StatusStockMutation.PENDING));

        log.info("Transferred {} units of product id: {} from warehouse id: {} to warehouse id: {}",
                quantity, product.getId(), fromWarehouse.getId().getValue(),
                toWarehouse.getId().getValue());

        return new StockTransferredEvent(fromStock, fromStock.getQuantity(), toStock.get().getQuantity(), product.getId().getValue(),  ZonedDateTime.now(ZoneId.of(UTC)), publisher) {
        };
    }


    @Override
    public void createUser(User user){
        user.validateUser();
        log.info("User with email: {} is created", user.getEmail());
    }

    private void validateUserAsWarehouseAdmin(User user) {
        if (user == null) {
            throw new WarehouseDomainException("User does not exist.");
        }
        if (!user.isActive()) {
            throw new WarehouseDomainException("User with id " + user.getId().getValue() + " is not active.");
        }
        if (!user.isWarehouseAdmin()) {
            throw new WarehouseDomainException("Only users with the Warehouse Admin role can be assigned.");
        }
    }

    private void validateStockTransfer(Warehouse fromWarehouse, Warehouse toWarehouse, Stock stock, int quantity) {
        if (quantity <= 0) {
            throw new WarehouseDomainException("Transfer quantity must be greater than zero.");
        }
        if (fromWarehouse.getId().equals(toWarehouse.getId())) {
            throw new WarehouseDomainException("From and to warehouses must be different.");
        }
        if (!fromWarehouse.hasSufficientStock(stock.getProductId(), quantity)) {
            throw new WarehouseDomainException("Insufficient stock in the from warehouse for this transfer.");
        }
    }





}
