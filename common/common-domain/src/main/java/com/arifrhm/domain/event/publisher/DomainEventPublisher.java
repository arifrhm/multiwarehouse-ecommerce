package com.arifrhm.domain.event.publisher;

import com.arifrhm.domain.event.DomainEvent;

public interface DomainEventPublisher <T extends DomainEvent> {

    void publish(T domainEvent);
}
