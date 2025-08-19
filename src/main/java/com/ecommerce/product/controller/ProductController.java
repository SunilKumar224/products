package com.ecommerce.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/Product")
@Tag(name = "Product Controller", description = "Controller that handles all Product related request mappings")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getAll")
	@Operation(summary = "Get All Products List", description = "Returns all Product details")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	public List<Product> getProductList() {

		List products = productService.findAll();
		return products;
	}
	
	@GetMapping("findProduct/{id}")
	@Operation(summary = "Get Product based on ID", description = "Returns Product details based on the ID")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	
	public Product getProductById(@PathVariable String id) {
		try {
			return productService.findById(id);
		} catch (Exception e) {
			return null;
		}
	}

	@PostMapping("/createProduct")
	@Operation(summary = "insert product details", description = "saving new product details")
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) })})

	public Product createNewProduct(@RequestBody Product product) {
		return productService.save(product);
	}

	@PutMapping("/updateProduct/{id}")
	@Operation(summary = "To update product details", description = "it will update the product with given details")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Product.class)) }),
			@ApiResponse(responseCode = "404", description = "Product not found", content = @Content) })
	
	public Product updateProduct(@PathVariable String id, @RequestBody Product product) {

		return productService.update(product);
	}

		
	@DeleteMapping("deleteProduct/{id}")
	@Operation(summary = "Delete Product based on ID", description = "It will delete the product details based on ID")	
	public ResponseEntity deleteProduct(@PathVariable String id) {
		try {
		Product product=productService.findById(id);
		productService.delete(product);
		}
		catch(Exception e) {
			System.out.println("Excepton occured");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("deleteAllProucts")
	@Operation(summary = "Delete All Products", description = "It will delete all the product details")	
	public ResponseEntity deleteAllProduct() {
		productService.DeleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
