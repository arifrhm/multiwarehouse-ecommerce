package multiwarehouse.payment_service;

import multiwarehouse.payment_service.entity.Payment;
import multiwarehouse.payment_service.exception.PaymentDomainException;

public class PaymentCreateHelper {
    private final PaymentDomainService paymentDomainService;

    private final PaymentRepository paymentRepo;

    private final PaymentDataMapper paymentDataMapper;

    private final PaymentCreatedEventPublisher paymentCreatedEventPublisher;

    public PaymentCreateHelper(PaymentDomainService paymentDomainService, PaymentRepository paymentRepo, PaymentDataMapper paymentDataMapper, PaymentCreatedEventPublisher paymentCreatedEventPublisher) {
        this.paymentDomainService = paymentDomainService;
        this.paymentRepo = paymentRepo;
        this.paymentDataMapper = paymentDataMapper;
        this.paymentCreatedEventPublisher = paymentCreatedEventPublisher;
    }

    public PaymentCreatedEvent persistPayment(CreatePaymentCommand createPaymentCommand) {
        Payment payment = paymentDataMapper.createPaymentCommandToPayment(payment);
        PaymentCreatedEvent paymentCreatedEvent = paymentDomainService.createPayment(payment, paymentCreatedEventPublisher);
        savePayment(payment);
        return paymentCreatedEvent;
    }

    private Payment savePayment(Payment payment) {
        Payment paymentResult = paymentRepo.save(payment);
        if (paymentResult == null) {
            throw new PaymentDomainException("Failed to save payment");
        }
        return paymentResult;
    }
}
