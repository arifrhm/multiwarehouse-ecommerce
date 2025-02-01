package multiwarehouse.payment_service;

import multiwarehouse.payment_service.event.PaymentCreatedEvent;

public class PaymentCreateCommandHandler {
    private final PaymentCreateHelper paymentCreateHelper;

    private final PaymentDataMapper paymentDataMapper;

    private final PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher;
    
    public PaymentCreateCommandHandler(PaymentCreateHelper paymentCreateHelper, 
            PaymentDataMapper paymentDataMapper, 
            PaymentCreatedRequestMessagePublisher paymentCreatedRequestMessagePublisher) {
        this.paymentCreateHelper = paymentCreateHelper;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentCreatedRequestMessagePublisher = paymentCreatedRequestMessagePublisher;
    }

    public CreatePaymentResponse createPayment(CreatePaymentCommand createPaymentCommand) {
        PaymentCreatedEvent paymentCreatedEvent = paymentCreateHelper.persistPayment(paymentDataMapper.createPaymentCommandToPayment(createPaymentCommand));
        paymentCreatedRequestMessagePublisher.publish(paymentCreatedEvent);
        return paymentDataMapper.paymentToCreatePaymentResponse(paymentCreatedEvent.getPayment());
    }
}
