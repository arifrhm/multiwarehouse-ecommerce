package com.arifrhm.product.service.domain.ports.input.message.listener.warehouse;


import com.arifrhm.product.service.domain.dto.message.StockResponseMessage;

public interface WarehouseServiceMessageListener {

    void onStockSaved(StockResponseMessage stockResponseMessage);
}
