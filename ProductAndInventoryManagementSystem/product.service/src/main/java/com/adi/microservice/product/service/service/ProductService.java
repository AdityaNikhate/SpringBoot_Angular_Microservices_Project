package com.adi.microservice.product.service.service;

import com.adi.microservice.product.service.dto.ProductResponse;
import com.adi.microservice.product.service.model.Product;
import com.adi.microservice.product.service.repository.ProductRepository;
import com.adi.microservice.product.service.dto.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest){
        try {
            Product product = Product.builder()
                    .name(productRequest.name())
                    .description(productRequest.description())
                    .price(productRequest.price())
                    .build();

            productRepository.save(product);
            log.info("{}: Product Created.", this.getClass().getName());
            return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
        } catch (RuntimeException e) {
            log.info("{}: Fail to save product. Error: {}", this.getClass().getName(),e.getMessage());
            return null;
        }
    }

    public List<ProductResponse> getAllProduct(){
        return productRepository
                .findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
