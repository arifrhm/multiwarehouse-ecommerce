package com.ecommerce.app.order.service.domain.ports.input.message.listener.sellerapproval;

import com.ecommerce.app.order.service.domain.dto.message.SellerApprovalResponse;

public interface SellerApprovalResponseMessageListener {
    void orderApproved(SellerApprovalResponse sellerApprovalResponse);

    void orderRejected(SellerApprovalResponse sellerApprovalResponse);
}
