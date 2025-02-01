package multiwarehouse.ecommerce.order.service.domain;

import multiwarehouse.ecommerce.order.service.domain.entity.Order;
import multiwarehouse.ecommerce.order.service.domain.entity.Seller;
import multiwarehouse.ecommerce.order.service.domain.event.OrderCancelledEvent;
import multiwarehouse.ecommerce.order.service.domain.event.OrderCreatedEvent;
import multiwarehouse.ecommerce.order.service.domain.event.OrderPaidEvent;
import multiwarehouse.ecommerce.domain.event.publisher.DomainEventPublisher;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, Seller seller,
                                               DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher);

    OrderPaidEvent payOrder(Order order, DomainEventPublisher<OrderPaidEvent> orderPaidEventDomainEventPublisher);

    void approveOrder(Order order);

    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages, DomainEventPublisher<OrderCancelledEvent> orderCancelledEventDomainEventPublisher);

    void cancelOrder(Order order, List<String> failureMessages);
}
