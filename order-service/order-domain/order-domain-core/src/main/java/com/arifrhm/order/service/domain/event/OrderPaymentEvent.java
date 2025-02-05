package com.arifrhm.order.service.domain.event;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public class OrderPaymentEvent extends OrderEvent{

    private final DomainEventPublisher<OrderPaymentEvent> orderPaymentEventDomainEventPublisher;

    public OrderPaymentEvent(Order order,
                             ZonedDateTime createdAt,
                             DomainEventPublisher<OrderPaymentEvent> orderPaymentEventDomainEventPublisher) {
        super(order, createdAt);
        this.orderPaymentEventDomainEventPublisher = orderPaymentEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        orderPaymentEventDomainEventPublisher.publish(this);
    }
}
