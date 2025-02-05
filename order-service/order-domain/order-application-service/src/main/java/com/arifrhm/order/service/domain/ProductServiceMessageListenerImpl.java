package com.arifrhm.order.service.domain;

import com.arifrhm.order.service.domain.dto.message.ProductResponseMessage;
import com.arifrhm.order.service.domain.entity.Product;
import com.arifrhm.order.service.domain.exception.OrderDomainException;
import com.arifrhm.order.service.domain.mapper.OrderDataMapper;
import com.arifrhm.order.service.domain.ports.input.message.listener.product.ProductServiceMessageListener;
import com.arifrhm.order.service.domain.ports.output.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductServiceMessageListenerImpl implements ProductServiceMessageListener {

    private final ProductRepository productRepository;
    private final OrderDataMapper orderDataMapper;

    public ProductServiceMessageListenerImpl(ProductRepository productRepository, OrderDataMapper orderDataMapper) {
        this.productRepository = productRepository;
        this.orderDataMapper = orderDataMapper;
    }

    @Override
    public void onProductCreated(ProductResponseMessage productResponseMessage) {

        Product mappedProduct = orderDataMapper.productResponseMessageToProduct(productResponseMessage);

        log.info("product price: {}", mappedProduct.getPrice());
        log.info("product price message: {}", productResponseMessage.getPrice());

        Product product = productRepository.save(mappedProduct);
        if (product == null) {
            log.error("Product is not saved with name: {}", product.getName());
            throw new OrderDomainException("Product is not saved with name: " + product.getName());
        }

        log.info("Product is saved with id: {}", product.getId());
    }

}
