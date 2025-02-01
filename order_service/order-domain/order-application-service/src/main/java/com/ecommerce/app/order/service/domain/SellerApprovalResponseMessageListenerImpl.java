package multiwarehouse.ecommerce.order.service.domain;

import multiwarehouse.ecommerce.order.service.domain.dto.message.SellerApprovalResponse;
import multiwarehouse.ecommerce.order.service.domain.event.OrderCancelledEvent;
import multiwarehouse.ecommerce.order.service.domain.ports.input.message.listener.sellerapproval.SellerApprovalResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static multiwarehouse.ecommerce.order.service.domain.entity.Order.FAILURE_MESSAGE_DELIMITER;

@Slf4j
@Validated
@Service
public class SellerApprovalResponseMessageListenerImpl implements SellerApprovalResponseMessageListener {

    private final OrderApprovalSaga orderApprovalSaga;

    public SellerApprovalResponseMessageListenerImpl(OrderApprovalSaga orderApprovalSaga) {
        this.orderApprovalSaga = orderApprovalSaga;
    }

    @Override
    public void orderApproved(SellerApprovalResponse sellerApprovalResponse) {
        orderApprovalSaga.process(sellerApprovalResponse);
        log.info("Order is approved for order id: {}", sellerApprovalResponse.getOrderId());
    }

    @Override
    public void orderRejected(SellerApprovalResponse sellerApprovalResponse) {
        OrderCancelledEvent domainEvent = orderApprovalSaga.rollback(sellerApprovalResponse);
        log.info("Publishing order cancelled event for order id: {} with failure messages: {}",
                sellerApprovalResponse.getOrderId(),
                String.join(FAILURE_MESSAGE_DELIMITER, sellerApprovalResponse.getFailureMessage()));
        domainEvent.fire();
    }
}
