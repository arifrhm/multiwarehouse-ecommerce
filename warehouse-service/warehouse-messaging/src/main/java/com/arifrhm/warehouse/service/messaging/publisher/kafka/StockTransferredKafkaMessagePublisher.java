package com.arifrhm.warehouse.service.messaging.publisher.kafka;

import com.arifrhm.warehouse.service.domain.event.StockTransferredEvent;
import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockTransferredEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockUpdatedEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class StockTransferredKafkaMessagePublisher implements StockTransferredEventPublisher {

    public StockTransferredKafkaMessagePublisher() {

    }

    @Override
    public void publish(StockTransferredEvent domainEvent) {

    }
}
