package com.arifrhm.warehouse.service.messaging.publisher.kafka;

import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;
import com.arifrhm.warehouse.service.domain.event.WarehouseUpdatedEvent;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockUpdatedEventPublisher;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.WarehouseUpdatedEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WarehouseUpdatedKafkaMessagePublisher implements WarehouseUpdatedEventPublisher {

    public WarehouseUpdatedKafkaMessagePublisher() {

    }

    @Override
    public void publish(WarehouseUpdatedEvent domainEvent) {

    }
}
