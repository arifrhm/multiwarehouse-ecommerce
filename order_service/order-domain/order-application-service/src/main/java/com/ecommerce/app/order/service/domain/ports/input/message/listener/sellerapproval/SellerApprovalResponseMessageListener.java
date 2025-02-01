package multiwarehouse.ecommerce.order.service.domain.ports.input.message.listener.sellerapproval;

import multiwarehouse.ecommerce.order.service.domain.dto.message.SellerApprovalResponse;

public interface SellerApprovalResponseMessageListener {
    void orderApproved(SellerApprovalResponse sellerApprovalResponse);

    void orderRejected(SellerApprovalResponse sellerApprovalResponse);
}
