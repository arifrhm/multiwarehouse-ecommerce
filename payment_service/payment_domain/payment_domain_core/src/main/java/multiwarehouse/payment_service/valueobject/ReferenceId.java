package multiwarehouse.payment_service.valueobject;

import java.util.UUID;

import multiwarehouse.common.domain.valueobject.BaseId;

public class ReferenceId extends BaseId<UUID> {
    public ReferenceId(UUID value) {
        super(value);
    }
}