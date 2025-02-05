package com.arifrhm.warehouse.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.warehouse.service.domain.event.StockCreatedEvent;

public interface StockCreatedEventPublisher extends DomainEventPublisher<StockCreatedEvent> {
}
