package com.ecommerce.app.order.service.domain.ports.output.repository;

import com.ecommerce.app.order.service.domain.entity.Customer;
import com.ecommerce.common.domain.valueobject.CustomerId;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> findById(CustomerId customerId);
}
