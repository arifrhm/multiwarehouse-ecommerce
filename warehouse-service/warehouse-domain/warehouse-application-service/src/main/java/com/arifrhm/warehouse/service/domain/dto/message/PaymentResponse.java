package com.arifrhm.warehouse.service.domain.dto.message;

import com.arifrhm.domain.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class PaymentResponse {
    private final String sagaId;
    private final String orderId;
    private final OrderStatus status;

}
