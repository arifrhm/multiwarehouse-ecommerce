package multiwarehouse.ecommerce.order.service.domain.ports.output.repository;

import multiwarehouse.ecommerce.order.service.domain.entity.Seller;

import java.util.Optional;

public interface SellerRepository {
    Optional<Seller> findSellerInformation(Seller seller);
}
