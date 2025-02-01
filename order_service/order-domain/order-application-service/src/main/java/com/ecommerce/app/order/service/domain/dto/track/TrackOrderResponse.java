package com.ecommerce.app.order.service.domain.dto.track;

import com.ecommerce.common.domain.valueobject.OrderId;
import com.ecommerce.common.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class TrackOrderResponse {
    private OrderId orderId;
    private OrderStatus orderStatus;
    private List<String> messages;
}
