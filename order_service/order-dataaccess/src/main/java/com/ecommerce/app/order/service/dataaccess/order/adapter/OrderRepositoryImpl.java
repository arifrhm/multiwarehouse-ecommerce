package multiwarehouse.ecommerce.order.service.dataaccess.order.adapter;

import multiwarehouse.ecommerce.domain.valueobject.OrderId;
import multiwarehouse.ecommerce.order.service.dataaccess.order.mapper.OrderDataAccessMapper;
import multiwarehouse.ecommerce.order.service.dataaccess.order.repository.OrderJpaRepository;
import multiwarehouse.ecommerce.order.service.domain.entity.Order;
import multiwarehouse.ecommerce.order.service.domain.ports.output.repository.OrderRepository;
import multiwarehouse.ecommerce.order.service.domain.valueobject.TrackingId;
import org.springframework.stereotype.Component;
import java.util.Optional;

@Component
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderDataAccessMapper orderDataAccessMapper;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository,
                               OrderDataAccessMapper orderDataAccessMapper) {
        this.orderJpaRepository = orderJpaRepository;
        this.orderDataAccessMapper = orderDataAccessMapper;
    }

    @Override
    public Order save(Order order) {
        return orderDataAccessMapper.orderEntityToOrder(orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order)));
    }

    @Override
    public Optional<Order> findById(OrderId orderId) {
        return orderJpaRepository.findById(orderId.getValue()).map(orderDataAccessMapper::orderEntityToOrder);
    }

    @Override
    public Optional<Order> findByTrackingId(TrackingId trackingId) {
        return orderJpaRepository.findByTrackingId(trackingId.getValue())
                .map(orderDataAccessMapper::orderEntityToOrder);
    }
}