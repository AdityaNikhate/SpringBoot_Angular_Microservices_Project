package com.adi.microservice.product.service.repository;

import com.adi.microservice.product.service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
