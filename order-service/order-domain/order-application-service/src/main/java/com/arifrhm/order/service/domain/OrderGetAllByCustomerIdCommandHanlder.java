package com.arifrhm.order.service.domain;

import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.order.service.domain.dto.create.OrderListResponse;
import com.arifrhm.order.service.domain.entity.User;
import com.arifrhm.order.service.domain.exception.OrderDomainException;
import com.arifrhm.order.service.domain.mapper.OrderDataMapper;
import com.arifrhm.order.service.domain.ports.output.repository.OrderRepository;
import com.arifrhm.order.service.domain.ports.output.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderGetAllByCustomerIdCommandHanlder {
    private final OrderRepository orderRepository;
    private final OrderDataMapper orderDataMapper;
    private final UserRepository userRepository;

    public OrderGetAllByCustomerIdCommandHanlder(OrderRepository orderRepository,
                                                 UserRepository userRepository,
                                                 OrderDataMapper orderDataMapper) {
        this.orderRepository = orderRepository;
        this.orderDataMapper = orderDataMapper;
        this.userRepository = userRepository;
    }

    public OrderListResponse getAllByCustomerId(String userId, int page, int size) {

        Optional<User> user = userRepository.findById(new UserId(UUID.fromString(userId)));
        if (user.isEmpty()) {
            new OrderDomainException("Could not find user with user id: " + userId);
        }

        log.info("Listing orders for page: {} with size: {}", page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.by("updatedAt").descending());
        return orderDataMapper.ordersToOrderListResponse(
                orderRepository.findByUserId(user.get().getId().getValue(), (pageable)));
    }
}
