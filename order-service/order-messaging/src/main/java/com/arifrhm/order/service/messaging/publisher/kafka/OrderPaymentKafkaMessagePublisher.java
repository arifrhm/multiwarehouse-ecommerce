package com.arifrhm.order.service.messaging.publisher.kafka;

import com.arifrhm.kafka.producer.KafkaMessageHelper;
import com.arifrhm.kafka.producer.service.KafkaProducer;
import com.arifrhm.order.service.domain.config.OrderServiceConfigData;
import com.arifrhm.order.service.domain.event.OrderPaymentEvent;
import com.arifrhm.order.service.domain.ports.output.message.publisher.OrderPaymentUpdateMessagePublisher;
import com.arifrhm.order.service.messaging.mapper.OrderMessagingDataMapper;
import com.arifrhm.payment.kafka.avro.model.PaymentResponseAvroModel;
import com.arifrhm.websocket.publisher.WebSocketPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderPaymentKafkaMessagePublisher implements OrderPaymentUpdateMessagePublisher {

    private final OrderMessagingDataMapper orderMessagingDataMapper;
    private final OrderServiceConfigData orderServiceConfigData;
    private final KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer;
    private final KafkaMessageHelper orderKafkaMessageHelper;
    private final WebSocketPublisher webSocketPublisher;

    public OrderPaymentKafkaMessagePublisher(OrderMessagingDataMapper orderMessagingDataMapper,
                                             OrderServiceConfigData orderServiceConfigData,
                                             KafkaProducer<String, PaymentResponseAvroModel> kafkaProducer,
                                             WebSocketPublisher webSocketPublisher,
                                             KafkaMessageHelper kafkaMessageHelper
                                            ) {
        this.orderMessagingDataMapper = orderMessagingDataMapper;
        this.orderServiceConfigData = orderServiceConfigData;
        this.kafkaProducer = kafkaProducer;
        this.webSocketPublisher = webSocketPublisher;
        this.orderKafkaMessageHelper = kafkaMessageHelper;
    }

    @Override
    public void publish(OrderPaymentEvent domainEvent) {
        String orderId = domainEvent.getOrder().getId().getValue().toString();
        log.info("publishing OrderPaymentEvent for order id: {}", orderId);

        try {
            PaymentResponseAvroModel paymentResponseAvroModel = orderMessagingDataMapper
                    .orderToPaymentResponseAvroModel(domainEvent);

            kafkaProducer.send(orderServiceConfigData.getPaymentResponseTopicName(),
                    orderId,
                    paymentResponseAvroModel,
                    orderKafkaMessageHelper
                            .getKafkaCallback(orderServiceConfigData.getPaymentResponseTopicName(),
                                    paymentResponseAvroModel,
                                    orderId,
                                    "paymentResponseAvroModel"));

            log.info("ws publishing to /topic/order-paid/" + domainEvent.getOrder().getUserId().getValue().toString());
            webSocketPublisher.publish("/topic/order-paid/" + domainEvent.getOrder().getUserId().getValue().toString(), "New order paid with ID: " + orderId);

            log.info("PaymentRequestAvroModel sent to Kafka for order id: {}", paymentResponseAvroModel.getOrderId());
        } catch (Exception e) {
            log.error("Error while sending OrderResponseAvroModel message" +
                    " to kafka with order id: {}, error: {}", orderId, e.getMessage());
        }
    }
}
