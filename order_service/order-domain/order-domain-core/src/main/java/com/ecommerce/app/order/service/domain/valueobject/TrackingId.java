package multiwarehouse.ecommerce.order.service.domain.valueobject;

import multiwarehouse.common.domain.valueobject.BaseId;

import java.util.UUID;

public class TrackingId extends BaseId<UUID> {
    public TrackingId(UUID value) {
        super(value);
    }
}
