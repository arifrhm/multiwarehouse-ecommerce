package com.arifrhm.warehouse.service.messaging.mapper;

import com.arifrhm.payment.kafka.avro.model.PaymentResponseAvroModel;
import com.arifrhm.product.kafka.avro.model.ProductResponseAvroModel;
import com.arifrhm.user.kafka.avro.model.UserResponseAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.WarehouseCreatedAvroModel;
import com.arifrhm.warehouse.kafka.order.avro.model.OrderResponseAvroModel;
import com.arifrhm.warehouse.service.domain.dto.message.OrderResponse;
import com.arifrhm.warehouse.service.domain.dto.message.PaymentResponse;
import com.arifrhm.warehouse.service.domain.dto.message.ProductResponseMessage;
import com.arifrhm.warehouse.service.domain.dto.message.UserResponseMessage;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.event.StockCreatedEvent;
import com.arifrhm.warehouse.service.domain.event.StockUpdatedEvent;
import com.arifrhm.warehouse.service.domain.event.WarehouseCreatedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class WarehouseMessagingDataMapper {

    public OrderResponse orderResponseAvroModelToOrderResponse(OrderResponseAvroModel orderResponseAvroModel) {
        return OrderResponse.builder()
                .id(orderResponseAvroModel.getId().toString())
                .sagaId(orderResponseAvroModel.getSagaId().toString())
                .orderId(orderResponseAvroModel.getOrderId().toString())
                .warehoudId(orderResponseAvroModel.getWarehouseId().toString())
                .createdAt(orderResponseAvroModel.getCreatedAt())
                .products(orderResponseAvroModel.getProducts().stream()
                        .map(product -> new OrderResponse.ProductQuantity(
                                product.getProductId().toString(),
                                product.getStockId().toString(),
                                product.getQuantity()))
                        .collect(Collectors.toList()))
                .build();
    }

    public WarehouseCreatedAvroModel warehouseCreatedEventToAvroModel(WarehouseCreatedEvent warehouseCreatedEvent) {
        Warehouse warehouse = warehouseCreatedEvent.getWarehouse();

        return WarehouseCreatedAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setWarehouseId(warehouse.getId().getValue())
                .setName(warehouse.getName())
                .setIsActive(warehouse.isActive())
                .setSagaId(UUID.randomUUID())
                .setCreatedAt(warehouseCreatedEvent.getCreatedAt().toInstant())
                .setAddress(com.arifrhm.warehouse.kafka.avro.model.WarehouseAddress.newBuilder()
                        .setStreet(warehouse.getStreetAddress().getStreet())
                        .setPostalCode(warehouse.getStreetAddress().getPostalCode())
                        .setCity(warehouse.getStreetAddress().getCity())
                        .setLatitude(warehouse.getStreetAddress().getLatitude())
                        .setLongitude(warehouse.getStreetAddress().getLongitude())
                        .build())
                .build();
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


    public StockCreatedAvroModel stockCreatedEventToStockCreatedAvroModel(StockCreatedEvent stockCreatedEvent) {
        return StockCreatedAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setStockId(stockCreatedEvent.getStock().getId().getValue())
                .setProductId(stockCreatedEvent.getStock().getProductId().getValue())
                .setWarehouseId(stockCreatedEvent.getStock().getWarehouseId().getValue())
                .setProductName(stockCreatedEvent.getProductName())
                .setWarehouseName(stockCreatedEvent.getWarehouseName())
                .setWarehouseLatitude(stockCreatedEvent.getWarehouseLatitude())
                .setWarehouseLongitude(stockCreatedEvent.getWarehouseLongitude())
                .setStock(stockCreatedEvent.getStock().getQuantity())
                .setSagaId(UUID.randomUUID())
                .setTotalProductStock(stockCreatedEvent.getProductTotalQuantity())
                .setEventTimestamp(stockCreatedEvent.getCreatedAt().toInstant())
                .build();
    }
    public StockUpdatedAvroModel stockUpdatedEventToStockUpdatedAvroModel(StockUpdatedEvent stockUpdatedEvent) {
        return StockUpdatedAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setStockId(stockUpdatedEvent.getStock().getId().getValue())
                .setProductId(stockUpdatedEvent.getStock().getProductId().getValue())
                .setWarehouseId(stockUpdatedEvent.getStock().getWarehouseId().getValue())
                .setStock(stockUpdatedEvent.getStock().getQuantity())
                .setSagaId(UUID.randomUUID())
                .setTotalProductStock(stockUpdatedEvent.getProductTotalQuantity())
                .setEventTimestamp(stockUpdatedEvent.getCreatedAt().toInstant())
                .build();
    }

    public PaymentResponse paymentResponseAvroModelToPaymentResponse(PaymentResponseAvroModel paymentResponseAvroModel) {
        return PaymentResponse.builder()
                .sagaId(paymentResponseAvroModel.getSagaId().toString())
                .orderId(paymentResponseAvroModel.getOrderId().toString())
                .status(mapOrderStatus(paymentResponseAvroModel.getOrderStatus()))
                .build();
    }

    private com.arifrhm.domain.valueobject.OrderStatus mapOrderStatus(com.arifrhm.payment.kafka.avro.model.OrderStatus orderStatus) {
        switch (orderStatus) {
            case PAID:
                return com.arifrhm.domain.valueobject.OrderStatus.PAID;
            case CANCELLING:
                return com.arifrhm.domain.valueobject.OrderStatus.CANCELLING;
            case CANCELLED:
                return com.arifrhm.domain.valueobject.OrderStatus.CANCELLED;
            case PENDING:
                return com.arifrhm.domain.valueobject.OrderStatus.PENDING;
            default:
                throw new IllegalArgumentException("Unknown OrderStatus: " + orderStatus);
        }
    }
}