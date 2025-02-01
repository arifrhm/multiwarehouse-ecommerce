package com.ecommerce.app.order.service.domain;

import com.ecommerce.app.order.service.domain.dto.message.PaymentResponse;
import com.ecommerce.app.order.service.domain.event.OrderPaidEvent;
import com.ecommerce.app.order.service.domain.ports.input.message.listener.payment.PaymentResponseMessageListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Slf4j
@Validated
@Service
public class PaymentResponseMessageListenerImpl implements PaymentResponseMessageListener {

    private final OrderPaymentSaga orderPaymentSaga;

    public PaymentResponseMessageListenerImpl(OrderPaymentSaga orderPaymentSaga) {
        this.orderPaymentSaga = orderPaymentSaga;
    }

    @Override
    public void paymentCompleted(PaymentResponse paymentResponse) {
        orderPaymentSaga.process(paymentResponse);
        log.info("Order Payment Saga process operation completed for order id: {}", paymentResponse.getOrderId().getValue());
    }

    @Override
    public void paymentCancelled(PaymentResponse paymentResponse) {
        orderPaymentSaga.rollback(paymentResponse);
        log.info("Order is rolled back for order id: {} with failure messages: {}",
                paymentResponse.getOrderId().getValue(),
                String.join(", ", paymentResponse.getMessage()));
    }
}
