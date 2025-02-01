package multiwarehouse.order_service.event;

import multiwarehouse.common.domain.event.publisher.DomainEventPublisher;
import multiwarehouse.common.domain.valueobject.CreatedAt;
import multiwarehouse.order_service.entity.Order;

public class SaleCreatedEvent extends OrderEvent {
    private final DomainEventPublisher<SaleCreatedEvent> saleCreatedEventDomainEventPublisher;

    public SaleCreatedEvent(Order order, CreatedAt createdAt, DomainEventPublisher<SaleCreatedEvent> saleCreatedEventDomainEventPublisher) {
        super(order, createdAt);
        this.saleCreatedEventDomainEventPublisher = saleCreatedEventDomainEventPublisher;
    }

    @Override
    public void fire() {
        saleCreatedEventDomainEventPublisher.publish(this);
    }
}
