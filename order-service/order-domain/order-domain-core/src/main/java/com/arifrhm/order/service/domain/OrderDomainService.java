package com.arifrhm.order.service.domain;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.entity.Stock;
import com.arifrhm.order.service.domain.entity.User;
import com.arifrhm.order.service.domain.entity.Warehouse;
import com.arifrhm.order.service.domain.event.OrderCreatedEvent;
import com.arifrhm.order.service.domain.event.OrderPaymentEvent;
import com.arifrhm.order.service.domain.valueobject.Invoice;

import java.util.List;

public interface OrderDomainService {
    OrderCreatedEvent validateAndInitiateOrder(Order order, List<Stock> stocks,
                                               Warehouse nearestWarehouse,
                                               DomainEventPublisher<OrderCreatedEvent> orderCreatedEventDomainEventPublisher);

    void validateInitialWarehouse(Warehouse warehouse);

    void invoicing(Order order, Invoice invoice);

    void createUser(User user);

    OrderPaymentEvent payOrder(Order order, DomainEventPublisher<OrderPaymentEvent> orderPaymentEventDomainEventPublisher);

    OrderPaymentEvent cancelOrder(Order order, DomainEventPublisher<OrderPaymentEvent> orderPaymentEventDomainEventPublisher);

}
