package com.ecommerce.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;

@RestController("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/getAll")
	public List<Product> getProductList(){
		
		List products=productService.findAll();
		return products;
	}
}
