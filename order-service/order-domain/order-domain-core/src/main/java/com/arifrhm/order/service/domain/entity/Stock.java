package com.arifrhm.order.service.domain.entity;

import com.arifrhm.domain.entity.BaseEntity;
import com.arifrhm.domain.valueobject.ProductId;
import com.arifrhm.domain.valueobject.StockId;
import com.arifrhm.domain.valueobject.WarehouseId;

public class Stock extends BaseEntity<StockId> {

    private WarehouseId warehouseId;

    private ProductId productId;

    private int quantity;

    public Stock(StockId stockId, WarehouseId warehouseId, ProductId productId, int quantity) {
        super.setId(stockId);
        this.warehouseId = warehouseId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Stock(StockId stockId){
        super.setId(stockId);}


    public void updateQuantity(int quantity) {
        this.quantity = quantity;
    }

    public WarehouseId getWarehouseId() {
        return warehouseId;
    }

    public ProductId getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
