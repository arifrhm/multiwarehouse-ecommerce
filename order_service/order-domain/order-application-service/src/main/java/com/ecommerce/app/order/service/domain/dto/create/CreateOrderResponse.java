package com.ecommerce.app.order.service.domain.dto.create;

import com.ecommerce.common.domain.valueobject.OrderId;
import com.ecommerce.common.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrderResponse {
    private OrderId orderId;
    private OrderStatus orderStatus;
    private List<String> messages;
}
