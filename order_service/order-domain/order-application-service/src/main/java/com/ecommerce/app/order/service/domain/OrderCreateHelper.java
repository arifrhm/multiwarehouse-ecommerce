package multiwarehouse.ecommerce.order.service.domain;

import multiwarehouse.ecommerce.order.service.domain.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.order.service.domain.entity.*;
import multiwarehouse.ecommerce.order.service.domain.event.*;
import multiwarehouse.ecommerce.order.service.domain.exception.*;
import multiwarehouse.ecommerce.order.service.domain.mapper.OrderDataMapper;
import multiwarehouse.ecommerce.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher;
import multiwarehouse.ecommerce.order.service.domain.ports.output.repository.CustomerRepository;
import multiwarehouse.ecommerce.order.service.domain.ports.output.repository.OrderRepository;
import multiwarehouse.ecommerce.order.service.domain.ports.output.repository.SellerRepository;
import lombok.extern.slf4j.Slf4j;
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

    private final OrderCreatedPaymentRequestMessagePublisher orderCreatedEventDomainEventPublisher;

    public OrderCreateHelper(OrderDomainService orderDomainService,
                             OrderRepository orderRepository,
                             CustomerRepository customerRepository,
                             SellerRepository sellerRepository,
                             OrderDataMapper orderDataMapper,
                             OrderCreatedPaymentRequestMessagePublisher orderCreatedEventDomainEventPublisher) {
        this.orderDomainService = orderDomainService;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
        this.orderDataMapper = orderDataMapper;
        this.orderCreatedEventDomainEventPublisher = orderCreatedEventDomainEventPublisher;
    }

    @Transactional
    public OrderCreatedEvent persistOrder(CreateOrderCommand createOrderCommand) {
        checkCustomer(createOrderCommand.getCustomerId());
        Seller seller = checkSeller(createOrderCommand);
        Order order = orderDataMapper.createOrderCommandToOrder(createOrderCommand);
        OrderCreatedEvent orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, seller,
                orderCreatedEventDomainEventPublisher);
        saveOrder(order);
        log.info("Order is created with id: {}", orderCreatedEvent.getOrder().getId().getValue());
        return orderCreatedEvent;
    }

    private Seller checkSeller(CreateOrderCommand createOrderCommand) {
        Seller seller = orderDataMapper.createOrderCommandToSeller(createOrderCommand);
        Optional<Seller> optionalSeller = sellerRepository.findSellerInformation(seller);
        if (optionalSeller.isEmpty()) {
            log.warn("Could not find seller with seller id: {}", createOrderCommand.getSellerId());
            throw new OrderDomainException("Could not find seller with seller id: " +
                    createOrderCommand.getSellerId());
        }
        return optionalSeller.get();
    }

    private void checkCustomer(UUID customerId) {
        Optional<Customer> customer = customerRepository.findCustomer(customerId);
        if (customer.isEmpty()) {
            log.warn("Could not find customer with customer id: {}", customerId);
            throw new OrderDomainException("Could not find customer with customer id: " + customer);
        }
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
