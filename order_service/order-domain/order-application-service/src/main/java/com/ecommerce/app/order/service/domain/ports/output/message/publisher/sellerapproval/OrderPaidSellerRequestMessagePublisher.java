package multiwarehouse.ecommerce.order.service.domain.ports.output.message.publisher.sellerapproval;

import multiwarehouse.ecommerce.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.ecommerce.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidSellerRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
