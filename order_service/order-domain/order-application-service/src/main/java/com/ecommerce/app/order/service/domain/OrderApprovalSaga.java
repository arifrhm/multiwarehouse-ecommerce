package com.ecommerce.app.order.service.domain;

import com.ecommerce.common.domain.saga.SagaStep;
import com.ecommerce.app.order.service.domain.entity.Order;
import com.ecommerce.app.order.service.domain.event.OrderCancelledEvent;
import com.ecommerce.app.order.service.domain.ports.output.message.publisher.payment.OrderCancelledPaymentRequestMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class OrderApprovalSaga implements SagaStep<OrderCancelledEvent> {

    private final OrderDomainService orderDomainService;
    private final OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher;

    public OrderApprovalSaga(OrderDomainService orderDomainService,
                             OrderCancelledPaymentRequestMessagePublisher orderCancelledPaymentRequestMessagePublisher) {
        this.orderDomainService = orderDomainService;
        this.orderCancelledPaymentRequestMessagePublisher = orderCancelledPaymentRequestMessagePublisher;
    }

    @Override
    @Transactional
    public void process(OrderCancelledEvent orderCancelledEvent) {
        Order order = orderCancelledEvent.getOrder();
        log.info("Order with id: {} is cancelled", order.getId().getValue());
    }

    @Override
    @Transactional
    public void rollback(OrderCancelledEvent orderCancelledEvent) {
        // No rollback for this saga
    }
}
