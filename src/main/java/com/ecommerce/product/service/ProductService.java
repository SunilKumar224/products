package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.entity.Product;

public interface ProductService {

	public List<Product> findAll();
	
	public Product save(Product product);
	
	public Product findById(String id) throws Exception;
	
	public Product update(Product product);
	
	public void delete(Product product);
	
	public void DeleteAll();
}
