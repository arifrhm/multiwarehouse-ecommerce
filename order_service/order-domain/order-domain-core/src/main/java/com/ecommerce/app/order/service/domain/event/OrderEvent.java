package multiwarehouse.ecommerce.order.service.domain.event;

import multiwarehouse.common.domain.event.DomainEvent;
import multiwarehouse.ecommerce.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public abstract class OrderEvent implements DomainEvent<Order> {
    private final Order order;
    private final ZonedDateTime createdAt;

    public OrderEvent(Order order, ZonedDateTime createdAt) {
        this.order = order;
        this.createdAt = createdAt;
    }

    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void fire() {
        // This method will be implemented by concrete event classes
    }
}
