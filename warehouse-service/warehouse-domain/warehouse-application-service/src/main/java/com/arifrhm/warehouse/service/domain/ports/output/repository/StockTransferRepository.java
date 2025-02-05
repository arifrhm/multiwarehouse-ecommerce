package com.arifrhm.warehouse.service.domain.ports.output.repository;

import com.arifrhm.warehouse.service.domain.valueobject.StockTransfer;

public interface StockTransferRepository {
    StockTransfer save(StockTransfer stockTransfer);

}
