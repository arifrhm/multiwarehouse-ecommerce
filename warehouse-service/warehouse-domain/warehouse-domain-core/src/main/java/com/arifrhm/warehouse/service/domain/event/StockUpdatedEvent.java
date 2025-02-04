package com.arifrhm.warehouse.service.domain.event;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.warehouse.service.domain.entity.Stock;

import java.time.ZonedDateTime;

public class StockUpdatedEvent extends StockEvent{

    private final int quantity;
    private Integer productTotalQuantity;

    private final DomainEventPublisher<StockUpdatedEvent> stockUpdatedEventDomainEventPublisher;

    public StockUpdatedEvent(Stock stock, int quantity, ZonedDateTime createdAt, DomainEventPublisher<StockUpdatedEvent> stockUpdatedEventDomainEventPublisher) {
        super(stock, createdAt);
        this.stockUpdatedEventDomainEventPublisher = stockUpdatedEventDomainEventPublisher;
        this.quantity = quantity;
    }

    public Integer getProductTotalQuantity() {
        return productTotalQuantity;
    }

    public void setProductTotalQuantity(Integer productTotalQuantity) {
        this.productTotalQuantity = productTotalQuantity;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void fire(){
        stockUpdatedEventDomainEventPublisher.publish(this);
    }
}
