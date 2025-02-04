package com.arifrhm.product.service.messaging.mapper;

import com.arifrhm.product.kafka.avro.model.ProductResponseAvroModel;
import com.arifrhm.product.service.domain.dto.message.StockResponseMessage;
import com.arifrhm.product.service.domain.dto.message.UserResponseMessage;
import com.arifrhm.product.service.domain.entity.Product;
import com.arifrhm.product.service.domain.event.ProductCreatedEvent;
import com.arifrhm.user.kafka.avro.model.UserResponseAvroModel;
import com.arifrhm.user.kafka.avro.model.UserRole;
import com.arifrhm.warehouse.kafka.avro.model.StockCreatedAvroModel;
import com.arifrhm.warehouse.kafka.avro.model.StockUpdatedAvroModel;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProductMessagingDataMapper {

    public ProductResponseAvroModel productCreatedEventToProductResponseAvroModel(ProductCreatedEvent productCreatedEvent) {
        Product product = productCreatedEvent.getProduct();

        return ProductResponseAvroModel.newBuilder()
                .setId(UUID.randomUUID())
                .setProductId(product.getId().getValue())
                .setName(product.getName())
                .setPrice(product.getPrice().toString())
                .setSagaId(UUID.randomUUID())
                .setTotalStock(product.getTotalStock())
                .setEventTimestamp(productCreatedEvent.getCreatedAt().toInstant())
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

    public StockResponseMessage stockCreatedAvroModelToStockResponseMessage(StockCreatedAvroModel stockCreatedAvroModel) {
        return StockResponseMessage.builder()
                .productId(stockCreatedAvroModel.getProductId().toString())
                .totalStockQuantity(stockCreatedAvroModel.getTotalProductStock())
                .eventTimestamp(stockCreatedAvroModel.getEventTimestamp())
                .build();
    }

    public StockResponseMessage stockUpdatedAvroModelToStockResponseMessage(StockUpdatedAvroModel stockUpdatedAvroModel) {
        return StockResponseMessage.builder()
                .productId(stockUpdatedAvroModel.getProductId().toString())
                .totalStockQuantity(stockUpdatedAvroModel.getTotalProductStock())
                .eventTimestamp(stockUpdatedAvroModel.getEventTimestamp())
                .build();
    }
}
