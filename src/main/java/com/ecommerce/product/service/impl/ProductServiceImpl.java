package com.ecommerce.product.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.product.entity.Category;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.repository.CategoryRepository;
import com.ecommerce.product.repository.ProductRepository;
import com.ecommerce.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		//Category category=product.getCategory();
		Optional<Category> category= Optional.ofNullable(categoryRepository.findByCategoryName(product.getCategory().getCategoryName()));
		if(category.isPresent()) {
		product.setCategory(category.get());
		}
		else {
			categoryRepository.save(product.getCategory());
		}
		return productRepository.save(product);
	}

	@Override
	public Product findById(String id) throws Exception {
		Optional<Product> product=productRepository.findById(id);
		if(product.isEmpty()){
			throw new Exception("product is not exist");
		}
		return product.get();
	}

	@Override
	public Product update(Product product) {
		return productRepository.save(product);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
		
	}

	@Override
	public void DeleteAll() {
		productRepository.deleteAll();
	}

	
}
