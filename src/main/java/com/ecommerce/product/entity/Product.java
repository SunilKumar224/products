package com.ecommerce.product.entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Product")
public class Product {
	
	@Id
	private String id;
	private String productId;
	private String productName;
	private String description;
	private float price;
	@DBRef
	private Category category;
	
	private String brand;
	private int stockQuantity;
	private String imageUrl;
	private Date createdTime;
	private Date updatedTime;
	private String createdBy;
	private String updatedBy;
	
}
