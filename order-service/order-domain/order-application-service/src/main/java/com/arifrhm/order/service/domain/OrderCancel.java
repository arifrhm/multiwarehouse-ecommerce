package com.arifrhm.order.service.domain;

import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.event.OrderPaymentEvent;
import com.arifrhm.order.service.domain.mapper.OrderDataMapper;
import com.arifrhm.order.service.domain.ports.output.message.publisher.OrderPaymentUpdateMessagePublisher;
import com.arifrhm.order.service.domain.ports.output.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class OrderCancel {

    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;
    private final OrderDomainService orderDomainService;
    private final OrderPaymentUpdateMessagePublisher orderPaymentUpdateMessagePublisher;

    public OrderCancel(OrderRepository orderRepository, OrderDataMapper orderDataMapper, OrderDomainService orderDomainService, OrderPaymentUpdateMessagePublisher orderPaymentUpdateMessagePublisher) {
        this.orderRepository = orderRepository;
        this.orderDataMapper = orderDataMapper;
        this.orderDomainService = orderDomainService;
        this.orderPaymentUpdateMessagePublisher = orderPaymentUpdateMessagePublisher;
    }

    public void orderCancel() {
        log.info("Processing order cancels");
        Optional<List<Order>> orderList = orderRepository.findExpiredOrders();
        if (orderList.isPresent()) {
            orderList.get().forEach(order -> {
                OrderPaymentEvent orderPaymentEvent = orderDomainService.cancelOrder(order, orderPaymentUpdateMessagePublisher);
                orderRepository.cancelOrder(order);
                log.info("Order cancel is done for order id: {}", order.getId().getValue());
                orderPaymentUpdateMessagePublisher.publish(orderPaymentEvent);
            });
        }
    }
}
