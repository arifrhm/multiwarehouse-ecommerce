package multiwarehouse.ecommerce.order.service.domain.rest;

import multiwarehouse.ecommerce.order.service.domain.dto.create.CreateOrderCommand;
import multiwarehouse.ecommerce.order.service.domain.dto.create.CreateOrderResponse;
import multiwarehouse.ecommerce.order.service.domain.ports.input.service.OrderApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/vnd.api.v1+json")
public class OrderController {

    private final OrderApplicationService orderApplicationService;

    public OrderController(OrderApplicationService orderApplicationService) {
        this.orderApplicationService = orderApplicationService;
    }

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderCommand createOrderCommand) {
        log.info("Creating order for customer: {} at seller: {}", createOrderCommand.getCustomerId(),
                createOrderCommand.getSellerId());
        CreateOrderResponse createOrderResponse = orderApplicationService.createOrder(createOrderCommand);
        return ResponseEntity.ok(createOrderResponse);
    }

}
