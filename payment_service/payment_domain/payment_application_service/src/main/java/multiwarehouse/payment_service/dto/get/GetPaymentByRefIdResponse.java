package multiwarehouse.payment_service.dto.get;

import jakarta.validation.constraints.NotNull;

public class GetPaymentByRefIdResponse {
    @NotNull
    private final PaymentId paymentId;
    @NotNull
    private final OrderId referenceId;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final PaymentStatus paymentStatus;
    private final String failedMessage;
    @NotNull
    private final Money amount;
    @NotNull
    private final CreatedAt createdAt;
}
