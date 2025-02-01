package com.ecommerce.app.order.service.domain.ports.output.message.publisher.payment;

import com.ecommerce.app.order.service.domain.event.OrderCancelledEvent;
import com.ecommerce.common.domain.event.publisher.DomainEventPublisher;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
