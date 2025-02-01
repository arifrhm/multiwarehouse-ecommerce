package com.ecommerce.app.order.service.domain;

import com.ecommerce.app.order.service.domain.entity.Order;
import com.ecommerce.app.order.service.domain.exception.OrderNotFoundException;
import com.ecommerce.app.order.service.domain.ports.output.repository.OrderRepository;
import com.ecommerce.common.domain.valueobject.OrderId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class OrderSagaHelper {

    private final OrderRepository orderRepository;

    public OrderSagaHelper(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    Order findOrder(OrderId orderId) {
        Optional<Order> orderResult = orderRepository.findById(orderId);
        if (orderResult.isEmpty()) {
            log.error("Order with id: {} could not be found!", orderId.getValue());
            throw new OrderNotFoundException("Order with id: " + orderId.getValue() +
                    " could not be found!");
        }
        return orderResult.get();
    }

    void saveOrder(Order order) {
        orderRepository.save(order);
    }
}