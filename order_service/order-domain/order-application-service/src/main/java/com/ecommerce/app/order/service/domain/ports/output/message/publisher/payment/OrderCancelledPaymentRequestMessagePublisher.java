package multiwarehouse.ecommerce.order.service.domain.ports.output.message.publisher.payment;

import multiwarehouse.ecommerce.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.ecommerce.order.service.domain.event.OrderCancelledEvent;

public interface OrderCancelledPaymentRequestMessagePublisher extends DomainEventPublisher<OrderCancelledEvent> {
}
