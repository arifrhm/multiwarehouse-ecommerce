package multiwarehouse.ecommerce.order.service.domain.valueobject;

import multiwarehouse.common.domain.valueobject.BaseId;
import java.util.UUID;

public class OrderItemId extends BaseId<UUID> {
    public OrderItemId(UUID value) {
        super(value);
    }
}
