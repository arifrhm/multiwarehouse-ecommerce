package com.arifrhm.order.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.order.service.domain.event.OrderPaymentEvent;

public interface OrderPaymentUpdateMessagePublisher extends DomainEventPublisher<OrderPaymentEvent> {

}
