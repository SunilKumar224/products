
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

import com.ecommerce.product.entity.Category;
import com.ecommerce.product.entity.Product;
import com.ecommerce.product.service.CategoryService;
import com.ecommerce.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/Category")
@Tag(name = "Category Controller", description = "Controller that handles all Category related request mappings")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/getAll")
	@Operation(summary = "Get All Category List", description = "Returns all Category details")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class)) }),
			@ApiResponse(responseCode = "404", description = "Category not found", content = @Content) })
	public List<Category> getCategoryList() {

		List<Category> category = categoryService.findAll();
		return category;
	}
	
	@GetMapping("findCategory/{id}")
	@Operation(summary = "Get Category based on ID", description = "Returns category details based on the ID")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class)) }),
			@ApiResponse(responseCode = "404", description = "Category not found", content = @Content) })
	
	public Category getCategoryById(@PathVariable String id) throws Exception {
		try {
			return categoryService.findById(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@PostMapping("/createCategory")
	@Operation(summary = "insert Category details", description = "saving new Category details")
	@ApiResponses({
		@ApiResponse(responseCode = "200", content = {
				@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class)) })})

	public Category createNewCategory(@RequestBody Category category) {
		return categoryService.save(category);
	}

	@PutMapping("/updateCategory/{id}")
	@Operation(summary = "To update Category details", description = "it will update the Category with given details")
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Category.class)) }),
			@ApiResponse(responseCode = "404", description = "Category not found", content = @Content) })
	
	public Category updateCategory(@PathVariable String id, @RequestBody Category category) {

		return categoryService.update(category);
	}

		
	@DeleteMapping("deleteCategory/{id}")
	@Operation(summary = "Delete Category based on ID", description = "It will delete the Category details based on ID")	
	public ResponseEntity deleteCategory(@PathVariable String id) {
		try {
			Category category=categoryService.findById(id);
			categoryService.delete(category);
		}
		catch(Exception e) {
			System.out.println("Excepton occured");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("deleteAllCategory")
	@Operation(summary = "Delete All Category", description = "It will delete all the Category details")	
	public ResponseEntity deleteAllCategory() {
		categoryService.DeleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
