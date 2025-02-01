package com.ecommerce.app.order.service.domain.ports.output.repository;

import com.ecommerce.app.order.service.domain.entity.Seller;
import com.ecommerce.common.domain.valueobject.SellerId;

import java.util.Optional;

public interface SellerRepository {

    Optional<Seller> findById(SellerId sellerId);
}
