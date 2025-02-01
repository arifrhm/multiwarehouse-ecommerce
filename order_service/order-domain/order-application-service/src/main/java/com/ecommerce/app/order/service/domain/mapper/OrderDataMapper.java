package multiwarehouse.ecommerce.order.service.domain.mapper;

import multiwarehouse.ecommerce.domain.valueobject.CustomerId;
import multiwarehouse.ecommerce.domain.valueobject.Money;
import multiwarehouse.ecommerce.domain.valueobject.ProductId;
import multiwarehouse.ecommerce.domain.valueobject.SellerId;
import multiwarehouse.ecommerce.order.service.domain.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.order.service.domain.dto.create.CreateOrderResponse;
import multiwarehouse.ecommerce.order.service.domain.dto.create.OrderAddress;
import multiwarehouse.ecommerce.order.service.domain.dto.track.TrackOrderResponse;
import multiwarehouse.ecommerce.order.service.domain.entity.Order;
import multiwarehouse.ecommerce.order.service.domain.entity.OrderItem;
import multiwarehouse.ecommerce.order.service.domain.entity.Product;
import multiwarehouse.ecommerce.order.service.domain.entity.Seller;
import multiwarehouse.ecommerce.order.service.domain.valueobject.*;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class OrderDataMapper {
    public Seller createOrderCommandToSeller(CreateOrderCommand createOrderCommand) {
        return Seller.builder()
                .sellerId(new SellerId(createOrderCommand.getSellerId()))
                .products(createOrderCommand.getItems().stream().map(orderItem ->
                                new Product(new ProductId(orderItem.getProductId())))
                        .collect(Collectors.toList()))
                .build();
    }

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


    public TrackOrderResponse orderToTrackOrderResponse(Order order) {
        return TrackOrderResponse.builder()
                .orderTrackingId(order.getTrackingId().getValue())
                .orderStatus(order.getOrderStatus())
                .failureMessage(order.getFailureMessages())
                .build();
    }

    private List<OrderItem> orderItemsToOrderItemEntities(
            @NotNull List<multiwarehouse.ecommerce.order.service.domain.dto.create.OrderItem> orderItems) {
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
