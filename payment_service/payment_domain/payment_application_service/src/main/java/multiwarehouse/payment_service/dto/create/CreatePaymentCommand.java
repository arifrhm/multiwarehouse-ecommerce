package multiwarehouse.payment_service.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

import multiwarehouse.common.domain.valueobject.Money;
import multiwarehouse.common.domain.valueobject.OrderId;
import multiwarehouse.payment_service.valueobject.PaymentMethod;
import multiwarehouse.payment_service.valueobject.PaymentStatus;

@Getter
@AllArgsConstructor
@Builder
public class CreatePaymentCommand {
    @NotNull
    private final OrderId referenceId;
    @NotNull
    private final PaymentMethod paymentMethod;
    @NotNull
    private final PaymentStatus paymentStatus;
    @NotNull
    private final Money amount;
}
