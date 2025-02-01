package multiwarehouse.ecommerce.order.service.domain.ports.output.repository;

import multiwarehouse.ecommerce.order.service.domain.entity.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {
    Optional<Customer> findCustomer(UUID customerId);
}
