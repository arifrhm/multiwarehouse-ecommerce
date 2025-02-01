package com.ecommerce.app.order.service.domain.ports.output.message.publisher.sellerapproval;

import com.ecommerce.common.domain.event.publisher.DomainEventPublisher;
import com.ecommerce.app.order.service.domain.event.OrderPaidEvent;

public interface OrderPaidSellerRequestMessagePublisher extends DomainEventPublisher<OrderPaidEvent> {
}
