package multiwarehouse.payment_service.payment.repository;

import multiwarehouse.payment_service.payment.entity.PaymentEntity;

@Component
public class PaymentDataAccessMapper {
    public PaymentEntity paymentToPaymentEntity(Payment payment) {
        PaymentEntity paymentEntity = PaymentEntity.builder()
                .id(payment.getId())
                .referenceId(payment.getReferenceId())  
                .paymentMethod(payment.getPaymentMethod()) 
                .paymentStatus(payment.getPaymentStatus())
                .failedMessage(payment.getFailedMessage())  
                .amount(payment.getAmount())
                .createdAt(payment.getCreatedAt())
                .build();
        return paymentEntity;
    }

    public Payment paymentEntityToPayment(PaymentEntity paymentEntity) {
        Payment payment = Payment.builder()
                .id(paymentEntity.getId())
                .referenceId(paymentEntity.getReferenceId())  
                .paymentMethod(paymentEntity.getPaymentMethod()) 
                .paymentStatus(paymentEntity.getPaymentStatus())
                .failedMessage(paymentEntity.getFailedMessage())  
                .amount(paymentEntity.getAmount())
                .createdAt(paymentEntity.getCreatedAt())
                .build();
        return payment;
    }
}