package multiwarehouse.common.domain.event.publisher;

import multiwarehouse.common.domain.event.DomainEvent;

public interface DomainEventPublisher<T extends DomainEvent> {
    void publish(T domainEvent);
}
