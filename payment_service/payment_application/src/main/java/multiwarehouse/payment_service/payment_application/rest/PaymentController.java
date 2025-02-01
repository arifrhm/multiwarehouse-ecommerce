package multiwarehouse.payment_service.payment_application.rest;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapper(path = "/payment")
public class PaymentContoller {
    private final PaymentApplicationService paymentApplicationService;

    public PaymentContoller(PaymentApplicationService paymentApplicationService) {
        this.paymentApplicationService = paymentApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreatePaymentResponse> createPayment(@RequestBody CreatePaymentCommand createPaymentCommand) {
        CreatePaymentResponse createPaymentResponse = paymentApplicationService.createPayment(createPaymentCommand);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPaymentResponse);   
    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<GetPaymentResponse> getPaymentByReferenceId(@PathVariable("referenceId") UUID referenceId) {
        GetPaymentResponse getPaymentResponse = paymentApplicationService.getPaymentByReferenceId(referenceId);
        return ResponseEntity.status(HttpStatus.OK).body(getPaymentResponse);
    }
}
