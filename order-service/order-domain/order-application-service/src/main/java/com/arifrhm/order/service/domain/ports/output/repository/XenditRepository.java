package com.arifrhm.order.service.domain.ports.output.repository;

import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.entity.User;
import com.arifrhm.order.service.domain.exception.XenditException;
import com.arifrhm.order.service.domain.valueobject.Invoice;

public interface XenditRepository {
    Invoice createInvoice(Order order, User user) throws XenditException;
}
