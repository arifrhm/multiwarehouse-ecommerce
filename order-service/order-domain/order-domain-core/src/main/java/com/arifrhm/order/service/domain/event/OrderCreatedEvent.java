package com.arifrhm.order.service.domain.event;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.entity.Warehouse;

import java.time.ZonedDateTime;

public class OrderCreatedEvent extends OrderEvent{

    private final Warehouse nearestWarehouse;
    private final DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher;

    public OrderCreatedEvent(Order order,
                             Warehouse nearestWarehouse,
                             ZonedDateTime createdAt,
                             DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher) {
        super(order, createdAt);
        this.nearestWarehouse = nearestWarehouse;
        this.orderCreatedEventDomainEventPublisher = orderCreatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderCreatedEventDomainEventPublisher.publish(this);
    }
}
