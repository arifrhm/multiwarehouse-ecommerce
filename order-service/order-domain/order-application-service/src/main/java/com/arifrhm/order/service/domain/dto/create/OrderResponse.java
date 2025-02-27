package com.arifrhm.order.service.domain.dto.create;

import com.arifrhm.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class OrderResponse {

    private final String message;
    @NotNull
    private final UUID orderTrackingId;
    @NotNull
    private final String invoiceUrl;
    @NotNull
    private final String invoiceNumber;
    @NotNull
    private final UUID orderId;
    @NotNull
    private final OrderAddress orderAddress;
    @NotNull
    private WarehouseRespone warehouse;
    @NotNull
    private final OrderStatus orderStatus;

    private final Date expiredAt;

    @NotNull
    private final BigDecimal totalAmount;
    @NotNull
    private List<OrderItemResponse> items;


    @Getter
    @AllArgsConstructor
    @Builder
    public static class WarehouseRespone {
        private final String name;
        private final String city;
        private final Double latitude;
        private final Double longitude;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class OrderItemResponse {
        private final ProductResponse product;
        private final Integer quantity;
        private final BigDecimal subTotal;
    }

    @Getter
    @AllArgsConstructor
    @Builder
    public static class ProductResponse {
        private final String productId;
        private final String name;
        private final BigDecimal price;
    }

}

