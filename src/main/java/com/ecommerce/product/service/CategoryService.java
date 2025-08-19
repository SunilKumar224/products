package com.ecommerce.product.service;

import java.util.List;

import com.ecommerce.product.entity.Category;

public interface CategoryService {

public List<Category> findAll();
	
	public Category save(Category category);
	
	public Category findById(String id) throws Exception;
	
	public Category update(Category category);
	
	public void delete(Category category);
	
	public void DeleteAll();
}
