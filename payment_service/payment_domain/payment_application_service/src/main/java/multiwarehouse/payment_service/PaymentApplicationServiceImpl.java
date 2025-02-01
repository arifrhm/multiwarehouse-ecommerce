package multiwarehouse.payment_service;

public class PaymentApplicationServiceImpl implements PaymentApplicationService {
    private final PaymentCreateCommandHandler paymentCreateCommandHandler;

    PaymentApplicationServiceImlp(PaymentCreateCommandHandler paymentCreateCommandHandler) {
        this.paymentCreateCommandHandler = paymentCreateCommandHandler;
    }
    @Override
    public CreatePaymentResponse createPayment(CreatePaymentCommand createPaymentCommand) {
        return paymentCreateCommandHandler.createPayment(createPaymentCommand);
    }
}
