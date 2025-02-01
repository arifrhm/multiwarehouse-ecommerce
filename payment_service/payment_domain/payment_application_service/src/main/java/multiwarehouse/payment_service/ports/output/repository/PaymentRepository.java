package multiwarehouse.payment_service.ports.output.repository;

import java.lang.foreign.Linker;

import multiwarehouse.payment_service.entity.Payment;

public interface PaymentRepository {
    Payment save(Payment payment);

    Optional<Payment> findPaymentByPaymentId(PaymentId paymentId);

    Optional<Payment> findPaymentByOrderId(OrderId orderId);    
}
