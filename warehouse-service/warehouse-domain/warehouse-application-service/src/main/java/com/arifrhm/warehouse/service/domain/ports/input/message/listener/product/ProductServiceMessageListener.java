package com.arifrhm.warehouse.service.domain.ports.input.message.listener.product;

import com.arifrhm.warehouse.service.domain.dto.message.ProductResponseMessage;
import com.arifrhm.warehouse.service.domain.dto.message.UserResponseMessage;

public interface ProductServiceMessageListener {

    void onProductCreated(ProductResponseMessage productResponseMessage);
}
