package com.arifrhm.warehouse.service.messaging.publisher.kafka;

import com.arifrhm.kafka.producer.KafkaMessageHelper;
import com.arifrhm.kafka.producer.service.KafkaProducer;
import com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel;
import com.arifrhm.warehouse.service.domain.config.WarehouseServiceConfigData;
import com.arifrhm.warehouse.service.domain.event.StockCreatedEvent;
import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;
import com.arifrhm.warehouse.service.domain.ports.output.message.publisher.StockUpdatedEventPublisher;
import com.arifrhm.warehouse.service.messaging.mapper.WarehouseMessagingDataMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class StockUpdatedKafkaMessagePublisher implements StockUpdatedEventPublisher {

    private final WarehouseMessagingDataMapper warehouseMessagingDataMapper;
    private final WarehouseServiceConfigData warehouseServiceConfigData;
    private final KafkaProducer<String, StockUpdatedAvroModel> kafkaProducer;
    private final KafkaMessageHelper kafkaMessageHelper;

    public StockUpdatedKafkaMessagePublisher(WarehouseMessagingDataMapper warehouseMessagingDataMapper,
                                             WarehouseServiceConfigData warehouseServiceConfigData,
                                             KafkaProducer<String, StockUpdatedAvroModel> kafkaProducer,
                                             KafkaMessageHelper kafkaMessageHelper) {
        this.warehouseMessagingDataMapper = warehouseMessagingDataMapper;
        this.warehouseServiceConfigData = warehouseServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.kafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(StockUpdatedEvent domainEvent) {

        String stockId = domainEvent.getStock().getId().getValue().toString();
        log.info("Received StockUpdatedEvent for stock id: {}", stockId);

        try {
            StockUpdatedAvroModel stockUpdatedAvroModel = warehouseMessagingDataMapper
                    .stockUpdatedEventToStockUpdatedAvroModel(domainEvent);

            kafkaProducer.send(warehouseServiceConfigData.getStockUpdatedTopicName(),
                    domainEvent.getStock().getProductId().getValue().toString(),
                    stockUpdatedAvroModel,
                    kafkaMessageHelper.getKafkaCallback(
                            warehouseServiceConfigData.getStockUpdatedTopicName(),
                            stockUpdatedAvroModel,
                            stockId,
                            "StockUpdatedAvroModel"
                    )
            );

            log.info("StockUpdatedAvroModel sent to Kafka for kafka id: {} and produt id: {} and total quantity: {}", stockUpdatedAvroModel.getId(), stockUpdatedAvroModel.getProductId(), stockUpdatedAvroModel.getTotalProductStock());
        } catch (Exception e) {
            log.error("Error while sending StockUpdatedAvroModel message to Kafka with stock id: {}, error: {}", stockId, e.getMessage());
        }

    }
}
