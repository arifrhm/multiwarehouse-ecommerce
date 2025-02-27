package com.arifrhm.order.service.dataaccess.warehouse.mapper;

import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.order.service.dataaccess.warehouse.entity.WarehouseEntity;
import com.arifrhm.order.service.domain.entity.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDataAccessMapper {

    public WarehouseEntity warehouseToWarehouseDataMapper(Warehouse warehouse){
         WarehouseEntity warehouseEntity = WarehouseEntity.builder()
                 .id(warehouse.getId().getValue())
                 .name(warehouse.getName())
                 .isActive(warehouse.isActive())
                 .name(warehouse.getName())
                 .build();

         return warehouseEntity;
    }

    public Warehouse warehouseEntityToWarehouse(WarehouseEntity warehouseEntity){
        return Warehouse.builder()
                .warehouseId(new WarehouseId(warehouseEntity.getId()))
                .name(warehouseEntity.getName())
                .city(warehouseEntity.getCity())
                .latitude(warehouseEntity.getLatitude())
                .longitude(warehouseEntity.getLongitude())
                .active(warehouseEntity.getIsActive())
                .build();
    }

    public WarehouseEntity warehouseToWarehouseEntity(Warehouse warehouse){
        return WarehouseEntity.builder()
                .id(warehouse.getId().getValue())
                .name(warehouse.getName())
                .city(warehouse.getCity())
                .latitude(warehouse.getLatitude())
                .longitude(warehouse.getLongitude())
                .isActive(warehouse.isActive())
                .build();
    }

}
