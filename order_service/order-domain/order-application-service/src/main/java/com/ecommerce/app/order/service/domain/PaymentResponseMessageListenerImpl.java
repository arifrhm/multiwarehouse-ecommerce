package multiwarehouse.ecommerce.order.service.domain;

import multiwarehouse.ecommerce.order.service.domain.dto.message.PaymentResponse;
import multiwarehouse.ecommerce.order.service.domain.event.OrderPaidEvent;
import multiwarehouse.ecommerce.order.service.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import static multiwarehouse.ecommerce.order.service.domain.entity.Order.FAILURE_MESSAGE_DELIMITER;


@Validated
@Service
@Slf4j
public class PaymentResponseMessageListenerImpl implements PaymentResponseMessageListener {

    private final OrderPaymentSaga orderPaymentSaga;

    public PaymentResponseMessageListenerImpl(OrderPaymentSaga orderPaymentSaga) {
        this.orderPaymentSaga = orderPaymentSaga;
    }

    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {
        OrderPaidEvent domainEvent = orderPaymentSaga.process(paymentResponse);
        log.info("Publishing OrderPaidEvent for order id: {}", paymentResponse.getOrderId());
        domainEvent.fire();
    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {
        orderPaymentSaga.rollback(paymentResponse);
        log.info("Order is roll backed for order id: {} with failure messages: {}",
                paymentResponse.getOrderId(),
                String.join(FAILURE_MESSAGE_DELIMITER, paymentResponse.getFailureMessage()));
    }
}
