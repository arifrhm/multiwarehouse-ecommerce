package multiwarehouse.payment_service.dto.get;

import jakarta.validation.constraints.NotNull;

public class GetPaymentByRefIdQuery {
    @NotNull
    private final OrderId referenceId;
}
