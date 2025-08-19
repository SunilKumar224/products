package com.ecommerce.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ecommerce.product.entity.Category;
import com.ecommerce.product.entity.Product;

public interface CategoryRepository extends MongoRepository<Category, String> {
	
	public Category findByCategoryName(String categoryName);

}
