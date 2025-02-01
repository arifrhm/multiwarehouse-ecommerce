package multiwarehouse.payment_service.dto.create;

import multiwarehouse.common.domain.valueobject.CreatedAt;
import multiwarehouse.common.domain.valueobject.OrderId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreatePaymentResponse {
    private final PaymentId paymentId;
    private final OrderId referenceId;
    private final PaymentMethod paymentMethod;
    private final PaymentStatus paymentStatus;
    private final String failedMessage;
    private final Money amount;
    private final CreatedAt createdAt;
}
