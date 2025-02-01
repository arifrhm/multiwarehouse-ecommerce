package com.ecommerce.app.order.service.domain.dto.message;

import com.ecommerce.common.domain.valueobject.OrderApprovalStatus;
import com.ecommerce.common.domain.valueobject.OrderId;
import com.ecommerce.common.domain.valueobject.SellerId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class SellerApprovalResponse {
    private OrderId orderId;
    private SellerId sellerId;
    private OrderApprovalStatus orderApprovalStatus;
    private List<String> failureMessages;
}
