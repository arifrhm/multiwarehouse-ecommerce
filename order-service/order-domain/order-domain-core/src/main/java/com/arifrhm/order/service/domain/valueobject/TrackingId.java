package com.arifrhm.order.service.domain.valueobject;

import com.arifrhm.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
