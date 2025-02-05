package com.arifrhm.warehouse.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;

public interface StockUpdatedEventPublisher extends DomainEventPublisher<StockUpdatedEvent> {
}
