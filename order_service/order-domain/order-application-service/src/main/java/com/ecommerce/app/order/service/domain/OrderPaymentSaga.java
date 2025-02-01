package com.ecommerce.app.order.service.domain;

import com.ecommerce.common.domain.saga.SagaStep;
import com.ecommerce.app.order.service.domain.dto.message.PaymentResponse;
import com.ecommerce.app.order.service.domain.entity.Order;
import com.ecommerce.app.order.service.domain.event.OrderPaidEvent;
import com.ecommerce.app.order.service.domain.exception.OrderDomainException;
import com.ecommerce.app.order.service.domain.ports.output.message.publisher.sellerapproval.OrderPaidSellerRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderPaymentSaga implements SagaStep<PaymentResponse> {

    private final OrderDomainService orderDomainService;
    private final OrderSagaHelper orderSagaHelper;
    private final OrderPaidSellerRequestMessagePublisher orderPaidSellerRequestMessagePublisher;

    public OrderPaymentSaga(OrderDomainService orderDomainService,
                          OrderSagaHelper orderSagaHelper,
                          OrderPaidSellerRequestMessagePublisher orderPaidSellerRequestMessagePublisher) {
        this.orderDomainService = orderDomainService;
        this.orderSagaHelper = orderSagaHelper;
        this.orderPaidSellerRequestMessagePublisher = orderPaidSellerRequestMessagePublisher;
    }

    @Override
    @Transactional
    public void process(PaymentResponse paymentResponse) {
        Order order = orderSagaHelper.findOrder(paymentResponse.getOrderId());
        OrderPaidEvent domainEvent = orderDomainService.payOrder(order);
        orderSagaHelper.saveOrder(order);
        orderPaidSellerRequestMessagePublisher.publish(domainEvent);
        log.info("Order with id: {} is paid", order.getId().getValue());
    }

    @Override
    @Transactional
    public void rollback(PaymentResponse paymentResponse) {
        Order order = orderSagaHelper.findOrder(paymentResponse.getOrderId());
        if (order.isPaid()) {
            throw new OrderDomainException("Order with id: " + order.getId().getValue() +
                    " is already paid!");
        }
        log.info("Cancelling order with id: {}", order.getId().getValue());
        orderDomainService.cancelOrder(order, paymentResponse.getMessage());
        orderSagaHelper.saveOrder(order);
        log.info("Order with id: {} is cancelled", order.getId().getValue());
    }
}