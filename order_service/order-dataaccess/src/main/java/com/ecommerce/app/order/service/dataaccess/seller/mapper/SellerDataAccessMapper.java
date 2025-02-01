package multiwarehouse.ecommerce.order.service.dataaccess.seller.mapper;

import multiwarehouse.ecommerce.dataaccess.seller.entity.SellerEntity;
import multiwarehouse.ecommerce.dataaccess.seller.exception.SellerDataAccessException;
import multiwarehouse.ecommerce.domain.valueobject.Money;
import multiwarehouse.ecommerce.domain.valueobject.ProductId;
import multiwarehouse.ecommerce.domain.valueobject.SellerId;
import multiwarehouse.ecommerce.order.service.domain.entity.Product;
import multiwarehouse.ecommerce.order.service.domain.entity.Seller;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SellerDataAccessMapper {

    public List<UUID> sellerToSellerProducts(Seller seller) {
        return seller.getProducts().stream()
                .map(product -> product.getId().getValue())
                .collect(Collectors.toList());
    }

    public Seller sellerEntityToSeller(List<SellerEntity> sellerEntities) {
        SellerEntity sellerEntity =
                sellerEntities.stream().findFirst().orElseThrow(() ->
                        new SellerDataAccessException("Seller could not be found!"));

        List<Product> sellerProducts = sellerEntities.stream().map(entity ->
                new Product(new ProductId(entity.getProductId()), entity.getProductName(),
                        new Money(entity.getProductPrice()))).toList();

        return Seller.builder()
                .sellerId(new SellerId(sellerEntity.getSellerId()))
                .products(sellerProducts)
                .active(sellerEntity.getSellerActive())
                .build();
    }
}
