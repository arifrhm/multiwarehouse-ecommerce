package com.arifrhm.warehouse.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.warehouse.service.domain.event.WarehouseCreatedEvent;

public interface WarehouseCreatedEventPublisher extends DomainEventPublisher<WarehouseCreatedEvent> {
}
