package com.arifrhm.product.service.domain;

import com.arifrhm.product.service.domain.dto.post.CreateProductCommand;
import com.arifrhm.product.service.domain.dto.response.ProductListResponse;
import com.arifrhm.product.service.domain.dto.response.ProductResponse;
import com.arifrhm.product.service.domain.exception.ImageUploadException;
import com.arifrhm.product.service.domain.exception.ProductDomainException;
import com.arifrhm.product.service.domain.ports.input.service.ProductApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Slf4j
@Validated
@Service
public class ProductApplicationServiceImpl implements ProductApplicationService {

    private final ProductCreateCommandHandler createProductCommandHandler;
    private final ProductListCommandHandler productListCommandHandler;

    public ProductApplicationServiceImpl(ProductCreateCommandHandler createProductCommandHandler,
                                         ProductListCommandHandler productListCommandHandler) {
        this.createProductCommandHandler = createProductCommandHandler;
        this.productListCommandHandler = productListCommandHandler;
    }

    @Override
    @Transactional
    public ResponseEntity<ProductResponse> createProduct(String name, BigDecimal price, MultipartFile file) {
        try {
            ProductResponse response = createProductCommandHandler.createProduct(name, price, file);
            return ResponseEntity.ok(response);
        } catch (ImageUploadException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ProductResponse.builder()
                            .message("Image upload failed: " + e.getMessage())
                            .build());
        } catch (ProductDomainException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ProductResponse.builder()
                            .message("Product creation failed: " + e.getMessage())
                            .build());
        }
    }

    @Override
    public ProductListResponse listProducts(int page, int size) {
        log.info("Listing products with page: {} and size: {}", page, size);
        return productListCommandHandler.listProducts(page, size);
    }
}
