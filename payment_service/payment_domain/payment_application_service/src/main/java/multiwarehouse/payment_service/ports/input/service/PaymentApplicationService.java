package multiwarehouse.payment_service.ports.input.service;

import javax.validation.Valid;
public interface PaymentApplicationService {
    CreatePaymentResponse createPayment(@Valid CreatePaymentCommand createPaymentCommand);
}