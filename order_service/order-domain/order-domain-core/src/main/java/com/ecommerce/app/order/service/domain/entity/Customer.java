package multiwarehouse.ecommerce.order.service.domain.entity;

import multiwarehouse.ecommerce.domain.entity.AggregateRoot;
import multiwarehouse.ecommerce.domain.valueobject.CustomerId;

public class Customer extends AggregateRoot<CustomerId> {
    public Customer() {
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }
}