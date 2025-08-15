package com.ecommerce.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.product.entity.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
