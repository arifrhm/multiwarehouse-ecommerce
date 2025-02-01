package multiwarehouse.payment_service.valueobject;

import multiwarehouse.common.domain.valueobject.BaseString;

public class FailedMessage extends BaseString<String>{
    public FailedMessage(String value) {
        super(value);
    }
}
