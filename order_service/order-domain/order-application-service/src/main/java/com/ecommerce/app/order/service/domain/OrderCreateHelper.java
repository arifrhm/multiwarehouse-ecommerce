package com.ecommerce.app.order.service.domain;

import lombok.extern.slf4j.Slf4j;
import com.ecommerce.common.domain.valueobject.OrderId;
import com.ecommerce.app.order.service.domain.dto.create.CreateOrderCommand;
import com.ecommerce.app.order.service.domain.entity.Customer;
import com.ecommerce.app.order.service.domain.entity.Order;
import com.ecommerce.app.order.service.domain.entity.Seller;
import com.ecommerce.app.order.service.domain.event.OrderCreatedEvent;
import com.ecommerce.app.order.service.domain.exception.OrderDomainException;
import com.ecommerce.app.order.service.domain.mapper.OrderDataMapper;
import com.ecommerce.app.order.service.domain.ports.output.repository.CustomerRepository;
import com.ecommerce.app.order.service.domain.ports.output.repository.OrderRepository;
import com.ecommerce.app.order.service.domain.ports.output.repository.SellerRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
public class OrderCreateHelper {

    private final OrderDomainService orderDomainService;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateHelper(OrderDomainService orderDomainService,
                           OrderRepository orderRepository,
                           CustomerRepository customerRepository,
                           SellerRepository sellerRepository,
                           OrderDataMapper orderDataMapper) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Seller seller = checkSeller(createOrderCommand.getSellerId());
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, seller);
        saveOrder(order);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customerId);
        }
    }

    private Seller checkSeller(UUID sellerId) {
        Optional<Seller> seller = sellerRepository.findById(sellerId);
        if (seller.isEmpty()) {
            log.warn("Could not find seller with seller id: {}", sellerId);
            throw new OrderDomainException("Could not find seller with seller id: " + sellerId);
        }
        return seller.get();
    }

    private Order saveOrder(Order order) {
        Order orderResult = orderRepository.save(order);
        if (orderResult == null) {
            log.error("Could not save order!");
            throw new OrderDomainException("Could not save order!");
        }
        log.info("Order is saved with id: {}", orderResult.getId().getValue());
        return orderResult;
    }
}
