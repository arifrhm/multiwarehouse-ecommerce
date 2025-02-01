package multiwarehouse.order_service;

import multiwarehouse.common.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.order_service.entity.Order;
import multiwarehouse.order_service.event.SaleCreatedEvent;

public interface OrderDomainService {
    SaleCreatedEvent saleCreatedEvent(Order order, DomainEventPublisher<SaleCreatedEvent> saleCreatedEventDomainEventPublisher);
}