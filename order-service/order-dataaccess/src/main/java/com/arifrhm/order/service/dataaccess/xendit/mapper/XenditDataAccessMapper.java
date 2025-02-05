package com.arifrhm.order.service.dataaccess.xendit.mapper;

import com.arifrhm.order.service.dataaccess.xendit.entity.InvoiceEntity;
import com.arifrhm.order.service.domain.entity.Order;
import com.arifrhm.order.service.domain.entity.User;
import com.arifrhm.order.service.domain.valueobject.Invoice;
import org.springframework.stereotype.Component;

@Component
public class XenditDataAccessMapper {

    public InvoiceEntity orderToXenditInvoice(Order order, User user) {
        return InvoiceEntity.builder()
                .externalId(order.getId().getValue().toString())
                .amount(order.getPrice().getAmount())
                .payerEmail(user.getEmail())
                .description("Order " + order.getId().getValue().toString())
//                .successRedirectUrl("ok redirect url")
//                .failureRedirectUrl("fail redirect url")
                .build();
    }


    public Invoice xenditInvoiceToInvoice(com.xendit.model.Invoice xenditInvoice) {
        return new Invoice(
                xenditInvoice.getId(),
                xenditInvoice.getInvoiceUrl()
        );
    }
}
