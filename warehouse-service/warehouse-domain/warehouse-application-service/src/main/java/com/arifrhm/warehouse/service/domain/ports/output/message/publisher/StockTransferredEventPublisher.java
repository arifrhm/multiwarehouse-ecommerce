package com.arifrhm.warehouse.service.domain.ports.output.message.publisher;

import com.arifrhm.domain.event.publisher.DomainEventPublisher;
import com.arifrhm.warehouse.service.domain.event.StockTransferredEvent;

public interface StockTransferredEventPublisher extends DomainEventPublisher<StockTransferredEvent> {
}