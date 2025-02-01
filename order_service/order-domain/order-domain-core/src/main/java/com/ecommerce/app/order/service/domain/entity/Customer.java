package multiwarehouse.ecommerce.order.service.domain.entity;

import multiwarehouse.common.domain.entity.AggregateRoot;
import multiwarehouse.common.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}