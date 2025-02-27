package com.arifrhm.order.service.domain.dto.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class WarehouseResponseMessage {
    private final String id;
    private final String sagaId;
    private final String warehoudId;
    private final String name;
    private final String city;
    private final Double latitude;
    private final Double longitude;
    private final Boolean isActive;

    private final Instant eventTimestamp;

}
