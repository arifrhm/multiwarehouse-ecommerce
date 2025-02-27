package com.arifrhm.warehouse.service.domain.rest;

import com.arifrhm.warehouse.service.domain.dto.create.*;
import com.arifrhm.warehouse.service.domain.dto.response.WarehouseProductStockResponse;
import com.arifrhm.warehouse.service.domain.ports.input.service.WarehouseApplicationService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
    @RequestMapping(value = "/warehouses", produces = "application/vnd.api.v1+json")
public class WarehouseController {

    private final WarehouseApplicationService warehouseApplicationService;

    public WarehouseController(WarehouseApplicationService warehouseApplicationService) {
        this.warehouseApplicationService = warehouseApplicationService;
    }

    // Create Warehouse
    @PostMapping
    public ResponseEntity<CreateWarehouseResponse> createWarehouse(@RequestBody CreateWarehouseCommand createWarehouseCommand) {
        log.info("Creating warehouse with name of {}", createWarehouseCommand.getName());
        CreateWarehouseResponse createWarehouseResponse = warehouseApplicationService.createWarehouse(createWarehouseCommand);
        log.info("Warehouse created with id: {}", createWarehouseResponse.getWarehouseId().toString());
        return ResponseEntity.ok(createWarehouseResponse);
    }

    @GetMapping
    public ResponseEntity<WarehouseListResponse> listWarehouses(@RequestParam(defaultValue = "0") int page,
                                                               @RequestParam(defaultValue = "10") int size) {
        WarehouseListResponse response = warehouseApplicationService.listWarehouses(page, size);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/stocks")
    public ResponseEntity<CreateStockResponse> createStock(@RequestBody @Valid CreateStockCommand createStockCommand) {
        CreateStockResponse createStockResponse = warehouseApplicationService.createStock(createStockCommand);
        log.info("Stock created with ID: {}", createStockResponse.getStockId());
        return ResponseEntity.ok(createStockResponse);
    }

    @PostMapping("/stocks/apply")
    public ResponseEntity<CreateStockResponse> updateStock(@RequestBody @Valid CreateUpdateStockCommand updateStockCommand) {
        CreateStockResponse updateStockResponse = warehouseApplicationService.updateStock(updateStockCommand);
        log.info("Stock applied with ID: {}", updateStockResponse.getStockId());
        return ResponseEntity.ok(updateStockResponse);
    }

    @GetMapping("/stocks")
    public ResponseEntity<WarehouseProductStockResponse> getStock(
            @RequestParam(name = "warehouseId") String warehouseId, @RequestParam(name = "productId") String productId) {
        WarehouseProductStockResponse response = warehouseApplicationService.getProductStockByWarehouse(UUID.fromString(warehouseId), UUID.fromString(productId));
        return ResponseEntity.ok(response);
    }

//
//    @PutMapping("/{id}")
//    public ResponseEntity<CreateWarehouseResponse> updateWarehouse(
//            @PathVariable UUID id,
//            @RequestBody CreateUpdateWarehouseCommand updateWarehouseCommand) {
//        log.info("Updating warehouse with id: {}", id);
//        CreateUpdateWarehouseCommand command = CreateUpdateWarehouseCommand.builder()
//                .warehouseId(id)
//                .name(updateWarehouseCommand.getName())
//                .warehouseAddress(updateWarehouseCommand.getWarehouseAddress())
//                .build();
//        CreateWarehouseResponse updateWarehouseResponse = warehouseApplicationService.updateWarehouse(command);
//        log.info("Warehouse updated with id: {}", updateWarehouseResponse.getWarehouseId());
//        return ResponseEntity.ok(updateWarehouseResponse);
//    }


}
