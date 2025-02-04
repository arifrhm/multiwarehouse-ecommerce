package com.arifrhm.warehouse.service.domain.event;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.warehouse.service.domain.entity.Stock;

import java.time.ZonedDateTime;
import java.util.UUID;

public class StockTransferredEvent extends StockEvent{

    private final DomainEventPublisher<StockTransferredEvent> stockTransferredEventDomainEventPublisher;

    private final int fromWarehouseQuantity;
    private final int toWarehouseQuantity;
    private final UUID productId;

    public StockTransferredEvent(Stock stock, int fromWarehouseQuantity, int toWarehouseQuantity, UUID productId, ZonedDateTime createdAt, DomainEventPublisher<StockTransferredEvent> stockTransferredEventDomainEventPublisher) {
        super(stock, createdAt);
        this.stockTransferredEventDomainEventPublisher = stockTransferredEventDomainEventPublisher;
        this.fromWarehouseQuantity = fromWarehouseQuantity;
        this.toWarehouseQuantity = toWarehouseQuantity;
        this.productId = productId;
    }

    public DomainEventPublisher<StockTransferredEvent> getStockTransferredEventDomainEventPublisher() {
        return stockTransferredEventDomainEventPublisher;
    }

    public int getFromWarehouseQuantity() {
        return fromWarehouseQuantity;
    }

    public int getToWarehouseQuantity() {
        return toWarehouseQuantity;
    }

    public UUID getProductId() {
        return productId;
    }

    @Override
    public void fire(){
        stockTransferredEventDomainEventPublisher.publish(this);
    }

}
