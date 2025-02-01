package multiwarehouse.ecommerce.order.service.domain.ports.input.message.listener.payment;

import multiwarehouse.ecommerce.order.service.domain.dto.message.PaymentResponse;

public interface PaymentResponseMessageListener {

    void paymentCompleted(PaymentResponse paymentResponse);

    void paymentCancelled(PaymentResponse paymentResponse);
}
