package multiwarehouse.ecommerce.order.service.domain.valueobject;

import multiwarehouse.ecommerce.domain.valueobject.BaseId;

public class OrderItemId extends BaseId<Long> {
    public OrderItemId(Long value) {
        super(value);
    }
}
