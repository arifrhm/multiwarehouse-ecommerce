package multiwarehouse.common.domain.valueobject;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class CreatedAt extends BaseTimestamp<ZonedDateTime> {
    public CreatedAt(ZonedDateTime value) {
        super(value);
    }

    public static CreatedAt now(ZoneId zoneId) {
        return new CreatedAt(ZonedDateTime.now(zoneId));
    }
}
