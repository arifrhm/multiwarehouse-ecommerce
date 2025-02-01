package multiwarehouse.payment_service.mapper;

import multiwarehouse.payment_service.entity.Payment;

public class PaymentDataMapper {
    public Payment createPaymentCommandToPayment(CreatePaymentCommand createPaymentCommand) {
        return Payment.builder()
                .referenceId(createPaymentCommand.getReferenceId())
                .paymentMethod(createPaymentCommand.getPaymentMethod())
                .paymentStatus(createPaymentCommand.getPaymentStatus())
                .amount(createPaymentCommand.getAmount())
                .build();
    }
}
