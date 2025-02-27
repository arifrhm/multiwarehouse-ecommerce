package com.arifrhm.warehouse.service.domain.mapper;

import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.UserId;
import com.arifrhm.domain.valueobject.UserRole;
import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.domain.dto.create.*;
import com.arifrhm.warehouse.service.domain.dto.message.ProductResponseMessage;
import com.arifrhm.warehouse.service.domain.dto.message.UserResponseMessage;
import com.arifrhm.warehouse.service.domain.entity.Product;
import com.arifrhm.warehouse.service.domain.entity.Stock;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.valueobject.StreetAddress;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class WarehouseDataMapper {

    public Warehouse createWarehouseCommandToWarehouse(CreateWarehouseCommand createWarehouseCommand){
        return Warehouse.builder()
                .name(createWarehouseCommand.getName())
                .streetAddress(warehouseAddressToStreetAddress(createWarehouseCommand.getWarehouseAddress()))
                .build();
    }

//    public Stock createSockCommandToStock(CreateStockCommand createStockCommand){
//        return Stock.builder()
//                .warehouseId(createStockCommand.getWarehouseId())
//                .productId(createStockCommand.getProductId())
//                .quantity(createStockCommand.getQuantity())
//                .build();
//    }

    public StreetAddress warehouseAddressToStreetAddress(WarehouseAddress warehouseAddress){
        return new StreetAddress(
                UUID.randomUUID(),
                warehouseAddress.getStreet(),
                warehouseAddress.getPostalCode(),
                warehouseAddress.getCity(),
                warehouseAddress.getLatitude(),
                warehouseAddress.getLongitude()
        );
    }

    public Stock createStockfromCreateStockCommand(CreateStockCommand createStockCommand){
        return Stock.builder()
                .warehouseId(new WarehouseId(createStockCommand.getWarehouseId()))
                .productId(new ProductId(createStockCommand.getProductId()))
                .quantity(createStockCommand.getQuantity())
                .build();

    }

    public Stock createStockFromCreateUpdateStockCommand(CreateUpdateStockCommand createUpdateStockCommand){
        return Stock.builder()
                .warehouseId(new WarehouseId(createUpdateStockCommand.getWarehouseId()))
                .productId(new ProductId(createUpdateStockCommand.getProductId()))
                .quantity(createUpdateStockCommand.getQuantity())
                .build();
    }

    public CreateWarehouseResponse warehouseToCreateWarehouseResponse(Warehouse warehouse, String message){
        return CreateWarehouseResponse.builder()
                .warehouseId(warehouse.getId().getValue())
                .isActive(warehouse.isActive())
                .message(message)
                .build();
    }


    public CreateStockResponse stockToCreateStockResponse(Stock stock, String message){
        return CreateStockResponse.builder()
                .stockId(stock.getId().getValue())
                .warehouseId(stock.getWarehouseId().getValue())
                .productId(stock.getProductId().getValue())
                .message(message)
                .build();
    }
    public CreateTransferStockResponse buildStockTransferredResponse(int fromStock, int toStock, UUID productId, String message){
        return CreateTransferStockResponse.builder()
                .fromWarehouseQuantity(fromStock)
                .toWarehouseQuantity(toStock)
                .productId(productId)
                .message(message)
                .build();
    }

    public com.arifrhm.warehouse.service.domain.entity.User userResponseMessageToUser(UserResponseMessage userResponseMessage) {
        return com.arifrhm.warehouse.service.domain.entity.User.builder()
                .userId(new UserId(UUID.fromString(userResponseMessage.getUserId())))
                .email(userResponseMessage.getEmail())
                .name(userResponseMessage.getName())
                .role(UserRole.valueOf(userResponseMessage.getRole()))
                .token(userResponseMessage.getToken())
                .isActive(userResponseMessage.isActive())
                .build();
    }

    public Product productResponseMessageToProduct(ProductResponseMessage productResponseMessage) {
        return new Product(
                new ProductId(UUID.fromString(productResponseMessage.getProductId())),
                productResponseMessage.getName(),
                productResponseMessage.getPrice()
        );
    }


    public WarehouseListResponse warehousePageToWarehouseListResponse(Page<Warehouse> warehousePage) {
        List<WarehouseResponse> warehouseResponses = warehousePage.getContent().stream()
                .map(warehouse -> WarehouseResponse.builder()
                        .warehouseId(warehouse.getId().getValue())
                        .name(warehouse.getName())
                        .isActive(warehouse.isActive())
                        .city(warehouse.getStreetAddress().getCity())
                        .street(warehouse.getStreetAddress().getStreet())
                        .postalCode(warehouse.getStreetAddress().getPostalCode())
                        .latitude(warehouse.getStreetAddress().getLatitude())
                        .longitude(warehouse.getStreetAddress().getLongitude())
                        .build())
                .collect(Collectors.toList());

        return WarehouseListResponse.builder()
                .warehouses(warehouseResponses)
                .totalElements(warehousePage.getTotalElements())
                .totalPages(warehousePage.getTotalPages())
                .currentPage(warehousePage.getNumber())
                .build();
    }

}
