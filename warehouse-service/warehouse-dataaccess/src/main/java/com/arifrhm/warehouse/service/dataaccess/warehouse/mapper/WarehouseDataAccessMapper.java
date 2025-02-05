package com.arifrhm.warehouse.service.dataaccess.warehouse.mapper;

import com.arifrhm.domain.valueobject.WarehouseId;
import com.arifrhm.warehouse.service.dataaccess.warehouse.entity.WarehouseAddressEntity;
import com.arifrhm.warehouse.service.dataaccess.warehouse.entity.WarehouseEntity;
import com.arifrhm.warehouse.service.domain.entity.Warehouse;
import com.arifrhm.warehouse.service.domain.valueobject.StreetAddress;
import org.springframework.stereotype.Component;

@Component
public class WarehouseDataAccessMapper {

    public WarehouseEntity warehouseToWarehouseDataMapper(Warehouse warehouse){
         WarehouseEntity warehouseEntity = WarehouseEntity.builder()
                 .id(warehouse.getId().getValue())
                 .name(warehouse.getName())
                 .isActive(warehouse.isActive())
                 .address(warehousAddressToAddressEntity(warehouse.getStreetAddress()))
                 .build();

         warehouseEntity.getAddress().setWarehouse(warehouseEntity);
         return warehouseEntity;
    }

    public Warehouse warehouseEntityToWarehouse(WarehouseEntity warehouseEntity){
        return Warehouse.builder()
                .warehouseId(new WarehouseId(warehouseEntity.getId()))
                .name(warehouseEntity.getName())
                .isActive(warehouseEntity.getIsActive())
                .streetAddress(addressEntityToWarehouseAddress(warehouseEntity.getAddress()))
                .build();
    }

    public WarehouseAddressEntity warehousAddressToAddressEntity(StreetAddress address){
        return WarehouseAddressEntity.builder()
                .id(address.getId())
                .city(address.getCity())
                .postalCode(address.getPostalCode())
                .street(address.getStreet())
                .latitude(address.getLatitude())
                .longitude(address.getLongitude())
                .build();
    }

    private StreetAddress addressEntityToWarehouseAddress(WarehouseAddressEntity address) {
        return new StreetAddress(address.getId(),
                address.getStreet(),
                address.getPostalCode(),
                address.getCity(),
                address.getLatitude(),
                address.getLongitude());
    }
}
