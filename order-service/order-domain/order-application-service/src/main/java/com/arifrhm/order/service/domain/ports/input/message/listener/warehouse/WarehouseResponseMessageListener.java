package com.arifrhm.order.service.domain.ports.input.message.listener.warehouse;


import com.arifrhm.order.service.domain.dto.message.StockCreatedResponseMessage;
import com.arifrhm.order.service.domain.dto.message.StockUpdatedResponseMessage;
import com.arifrhm.order.service.domain.dto.message.WarehouseResponseMessage;

public interface WarehouseResponseMessageListener {

    void onWarehouseSave(WarehouseResponseMessage warehouseResponseMessage);

    void onStockCreated(StockCreatedResponseMessage stockCreatedResponseMessage);

    void onStockUpdated(StockUpdatedResponseMessage stockUpdatedResponseMessage);

}
