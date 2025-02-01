package multiwarehouse.order_service;

import java.time.ZoneId;

import multiwarehouse.common.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.common.domain.valueobject.CreatedAt;
import multiwarehouse.order_service.entity.Order;
import multiwarehouse.order_service.event.SaleCreatedEvent;

public class OrderDomainServiceImpl implements OrderDomainService {
    private static final String UTC = "UTC";

    @Override
    public SaleCreatedEvent saleCreatedEvent(Order order, DomainEventPublisher<SaleCreatedEvent> saleCreatedEventDomainEventPublisher) {
        return new SaleCreatedEvent(order, CreatedAt.now(ZoneId.of(UTC)), saleCreatedEventDomainEventPublisher);
    }
}