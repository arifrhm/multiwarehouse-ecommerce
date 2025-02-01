package multiwarehouse.ecommerce.order.service.dataaccess.customer.mapper;

import multiwarehouse.ecommerce.domain.valueobject.CustomerId;
import multiwarehouse.ecommerce.order.service.dataaccess.customer.entity.CustomerEntity;
import multiwarehouse.ecommerce.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataAccessMapper {

    public Customer customerEntityToCustomer(CustomerEntity customerEntity) {
        return new Customer(new CustomerId(customerEntity.getId()));
    }
}