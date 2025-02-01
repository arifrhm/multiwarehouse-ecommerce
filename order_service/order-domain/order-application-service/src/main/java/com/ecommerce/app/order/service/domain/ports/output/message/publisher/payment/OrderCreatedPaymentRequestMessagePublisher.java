package com.ecommerce.app.order.service.domain.ports.output.message.publisher.payment;

import com.ecommerce.common.domain.event.publisher.DomainEventPublisher;
import com.ecommerce.app.order.service.domain.event.OrderCreatedEvent;

public interface OrderCreatedPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCreatedEvent> {

}
