package multiwarehouse.ecommerce.order.service.domain.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
@Builder
public class CreateOrderCommand {
    @NotNull
    private final UUID customerId;
    @NotNull
    private final UUID sellerId;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final List<OrderItem> items;
    @NotNull
    private final OrderAddress address;
}
