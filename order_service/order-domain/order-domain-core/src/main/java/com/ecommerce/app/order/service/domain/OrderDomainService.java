package multiwarehouse.ecommerce.order.service.domain;

import multiwarehouse.ecommerce.order.service.domain.entity.Order;
import multiwarehouse.ecommerce.order.service.domain.entity.Seller;
import multiwarehouse.ecommerce.order.service.domain.event.OrderCancelledEvent;
import multiwarehouse.ecommerce.order.service.domain.event.OrderCreatedEvent;
import multiwarehouse.ecommerce.order.service.domain.event.OrderPaidEvent;

import java.util.List;

public interface OrderDomainService {

    OrderCreatedEvent validateAndInitiateOrder(Order order, Seller seller);
    
    OrderPaidEvent payOrder(Order order);
    
    void approveOrder(Order order);
    
    OrderCancelledEvent cancelOrderPayment(Order order, List<String> failureMessages);
    
    void cancelOrder(Order order, List<String> failureMessages);
}
