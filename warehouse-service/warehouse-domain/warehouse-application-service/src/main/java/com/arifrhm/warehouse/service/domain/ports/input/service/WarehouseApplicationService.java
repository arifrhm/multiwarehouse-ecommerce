package com.arifrhm.warehouse.service.domain.ports.input.service;


import com.arifrhm.warehouse.service.domain.dto.create.*;
import com.arifrhm.warehouse.service.domain.dto.response.WarehouseProductStockResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface WarehouseApplicationService {

    CreateWarehouseResponse createWarehouse(@Valid CreateWarehouseCommand createWarehouseCommand);

    CreateWarehouseResponse updateWarehouse(@Valid CreateUpdateWarehouseCommand updateWarehouseCommand);

    WarehouseListResponse listWarehouses(int page, int size);

//    AssignAdminResponse assignWarehouseAdmin(@Valid AssignAdminCommand assignAdminCommand);

    CreateTransferStockResponse transferStock(@Valid CreateTransferStockCommand stockTransferCommand);

    CreateStockResponse createStock(@Valid CreateStockCommand createStockCommand);

    CreateStockResponse updateStock(@Valid CreateUpdateStockCommand updateSTockCommand);

    WarehouseProductStockResponse getProductStockByWarehouse(UUID warehouseId, UUID productId);

}
