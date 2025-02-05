package com.arifrhm.order.service.messaging.mapper;

import com.arifrhm.order.service.domain.dto.message.*;
import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.event.OrderCreatedEvent;
import com.arifrhm.order.service.domain.event.OrderPaymentEvent;
import com.arifrhm.payment.kafka.avro.model.PaymentResponseAvroModel;
import com.arifrhm.product.kafka.avro.model.ProductResponseAvroModel;
import com.arifrhm.user.kafka.avro.model.UserResponseAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.WarehouseCreatedAvroModel;
import com.arifrhm.warehouse.kafka.order.avro.model.OrderResponseAvroModel;
import com.arifrhm.warehouse.kafka.order.avro.model.OrderStatus;
import com.arifrhm.warehouse.kafka.order.avro.model.ProductQuantity;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderMessagingDataMapper {

    public OrderResponseAvroModel orderCreatedEventToOrderResponseAvroModel(OrderCreatedEvent orderCreatedEvent) {
        Order order = orderCreatedEvent.getOrder();

        return OrderResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.randomUUID())
                .setOrderId(order.getId().getValue())
                .setWarehouseId(order.getWarehouse().getId().getValue())
                .setCreatedAt(orderCreatedEvent.getCreatedAt().toInstant())
                .setOrderStatus(mapOrderStatus(order.getOrderStatus()))
                .setProducts(
                        order.getItems().stream()
                                .map(item -> ProductQuantity.newBuilder()
                                        .setProductId(item.getProduct().getId().getValue())
                                        .setStockId(item.getOrderId().getValue())
                                        .setQuantity(item.getQuantity())
                                        .build()
                                )
                                .collect(Collectors.toList())
                )
                .build();
    }

    private OrderStatus mapOrderStatus(com.arifrhm.domain.valueobject.OrderStatus orderStatus) {
        return switch (orderStatus) {
            case PENDING -> OrderStatus.PENDING;
            case PAID -> OrderStatus.PAID;
            case APPROVED -> OrderStatus.APPROVED;
            case CANCELLING -> OrderStatus.CANCELLING;
            case CANCELLED -> OrderStatus.CANCELLED;
        };
    }

    public UserResponseMessage userAvroModelToUserResponseMessage(UserResponseAvroModel userResponseMessage) {
        return UserResponseMessage.builder()
                .email(userResponseMessage.getEmail())
                .userId(userResponseMessage.getUserId().toString())
                .name(userResponseMessage.getName())
                .role(userResponseMessage.getRole().toString())
                .token(userResponseMessage.getToken())
                .isActive(userResponseMessage.getIsActive())
                .eventTimestamp(userResponseMessage.getEventTimestamp())
                .build();
    }

    public ProductResponseMessage productResponseMessageToProduct(ProductResponseAvroModel productResponseAvroModel) {
        return ProductResponseMessage.builder()
                .id(productResponseAvroModel.getId().toString())
                .sagaId(productResponseAvroModel.getSagaId().toString())
                .productId(productResponseAvroModel.getProductId().toString())
                .name(productResponseAvroModel.getName())
                .price(new BigDecimal(productResponseAvroModel.getPrice()))
                .eventTimestamp(productResponseAvroModel.getEventTimestamp())
                .build();

    }

    public WarehouseResponseMessage warehouseCreatedAvroModelToWarehouseResponse(WarehouseCreatedAvroModel warehouseCreatedAvroModel) {
        return WarehouseResponseMessage.builder()
                .id(warehouseCreatedAvroModel.getId().toString())
                .sagaId(warehouseCreatedAvroModel.getSagaId().toString())
                .warehoudId(warehouseCreatedAvroModel.getWarehouseId().toString())
                .name(warehouseCreatedAvroModel.getName())
                .city(warehouseCreatedAvroModel.getAddress().getCity())
                .latitude(warehouseCreatedAvroModel.getAddress().getLatitude())
                .longitude(warehouseCreatedAvroModel.getAddress().getLongitude())
                .isActive(warehouseCreatedAvroModel.getIsActive())
                .eventTimestamp(warehouseCreatedAvroModel.getCreatedAt())
                .build();

    }

    public StockCreatedResponseMessage stockCreatedAvroModelToStockCreatedResponseMessage(StockCreatedAvroModel stockCreatedAvroModel) {
        return StockCreatedResponseMessage.builder()
                .id(stockCreatedAvroModel.getId().toString())
                .sagaId(stockCreatedAvroModel.getSagaId().toString())
                .stockId(stockCreatedAvroModel.getStockId().toString())
                .warehouseId(stockCreatedAvroModel.getWarehouseId().toString())
                .productId(stockCreatedAvroModel.getProductId().toString())
                .warehouseName(stockCreatedAvroModel.getWarehouseName())
                .productName(stockCreatedAvroModel.getProductName())
                .warehouseLongitude(stockCreatedAvroModel.getWarehouseLongitude())
                .warehouseLatitude(stockCreatedAvroModel.getWarehouseLatitude())
                .stock(stockCreatedAvroModel.getStock())
                .eventTimestamp(stockCreatedAvroModel.getEventTimestamp())
                .build();
    }

    public StockUpdatedResponseMessage stockUpdatedAvroModelToStockUpdatedResponseMessage(StockUpdatedAvroModel stockUpdatedAvroModel) {
        return StockUpdatedResponseMessage.builder()
                .id(stockUpdatedAvroModel.getId().toString())
                .sagaId(stockUpdatedAvroModel.getSagaId().toString())
                .stockId(stockUpdatedAvroModel.getStockId().toString())
                .warehouseId(stockUpdatedAvroModel.getWarehouseId().toString())
                .productId(stockUpdatedAvroModel.getProductId().toString())
                .stock(stockUpdatedAvroModel.getStock())
                .eventTimestamp(stockUpdatedAvroModel.getEventTimestamp())
                .build();
    }

    public PaymentResponseAvroModel orderToPaymentResponseAvroModel(OrderPaymentEvent orderPaymentEvent) {
        return PaymentResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setSagaId(UUID.randomUUID())
                .setOrderId(orderPaymentEvent.getOrder().getId().getValue())
                .setCreatedAt(orderPaymentEvent.getCreatedAt().toInstant())
                .setOrderStatus(mapOrderStatusPayment(orderPaymentEvent.getOrder().getOrderStatus()))
                .build();
    }

    private com.arifrhm.payment.kafka.avro.model.OrderStatus mapOrderStatusPayment(com.arifrhm.domain.valueobject.OrderStatus orderStatus) {
        return switch (orderStatus) {
            case PENDING -> com.arifrhm.payment.kafka.avro.model.OrderStatus.PENDING;
            case PAID -> com.arifrhm.payment.kafka.avro.model.OrderStatus.PAID;
            case APPROVED -> com.arifrhm.payment.kafka.avro.model.OrderStatus.APPROVED;
            case CANCELLING -> com.arifrhm.payment.kafka.avro.model.OrderStatus.CANCELLING;
            case CANCELLED -> com.arifrhm.payment.kafka.avro.model.OrderStatus.CANCELLED;
        };
    }
}