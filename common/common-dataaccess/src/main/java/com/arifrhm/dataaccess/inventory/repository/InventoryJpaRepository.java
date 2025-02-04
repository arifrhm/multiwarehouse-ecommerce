package com.arifrhm.dataaccess.inventory.repository;

import com.arifrhm.dataaccess.inventory.entity.InventoryEntity;
import com.arifrhm.dataaccess.inventory.entity.InventoryEntityId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryJpaRepository extends JpaRepository<InventoryEntity, InventoryEntityId> {

//    Optional< List<InventoryEntity> > findByWarehouseIdAndProductIdIn(UUID warehouseId, List<UUID> productIds);
}
