package com.ecommerce.app.order.service.domain.mapper;

import com.ecommerce.app.order.service.domain.dto.create.CreateOrderCommand;
import com.ecommerce.app.order.service.domain.dto.create.CreateOrderResponse;
import com.ecommerce.app.order.service.domain.dto.create.OrderAddress;
import com.ecommerce.app.order.service.domain.dto.track.TrackOrderResponse;
import com.ecommerce.common.domain.valueobject.*;
import com.ecommerce.app.order.service.domain.entity.Order;
import com.ecommerce.app.order.service.domain.entity.OrderItem;
import com.ecommerce.app.order.service.domain.entity.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Order createOrderCommandToOrder(CreateOrderCommand createOrderCommand) {
        return Order.builder()
                .customerId(new CustomerId(createOrderCommand.getCustomerId()))
                .sellerId(new SellerId(createOrderCommand.getSellerId()))
                .deliveryAddress(orderAddressToStreetAddress(createOrderCommand.getAddress()))
                .price(new Money(createOrderCommand.getPrice()))
                .items(orderItemsToOrderItemEntities(createOrderCommand.getItems()))
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order, String message) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message(message)
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order) {
        return CreateOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .message("Order created successfully")
                .build();
    }

    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessages(order.getFailureMessages())
                .build();
    }

    public CreateOrderResponse createOrderResponse(OrderId orderId,
                                                OrderStatus orderStatus,
                                                List<String> messages) {
        return CreateOrderResponse.builder()
                .orderId(orderId)
                .orderStatus(orderStatus)
                .messages(messages)
                .build();
    }

    public TrackOrderResponse createOrderTrackResponse(OrderId orderId,
                                                     OrderStatus orderStatus,
                                                     List<String> messages) {
        return TrackOrderResponse.builder()
                .orderId(orderId)
                .orderStatus(orderStatus)
                .messages(messages)
                .build();
    }

    public Address createOrderAddress(OrderAddress orderAddress) {
        return new Address(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            List<com.ecommerce.app.order.service.domain.dto.create.OrderItem> orderItems) {
        return orderItems.stream()
                .map(orderItem ->
                        OrderItem.builder()
                                .product(new Product(new ProductId(orderItem.getProductId())))
                                .price(new Money(orderItem.getPrice()))
                                .quantity(orderItem.getQuantity())
                                .subTotal(new Money(orderItem.getSubTotal()))
                                .build()).collect(Collectors.toList());
    }

    private StreetAddress orderAddressToStreetAddress(OrderAddress orderAddress) {
        return new StreetAddress(
                UUID.randomUUID(),
                orderAddress.getStreet(),
                orderAddress.getPostalCode(),
                orderAddress.getCity()
        );
    }
}
