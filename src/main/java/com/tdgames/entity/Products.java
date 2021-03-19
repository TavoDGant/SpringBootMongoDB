package com.tdgames.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Products {

	@Transient
	public static final String SEQUENCE_NAME = "users_sequence"; 
	
	@Id
	private String id;
	
	private String name;
	private String description;
	private Double price;
		
	public Products() {
		super();
	}	
	public Products(String id, String name, String description, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
		
	
}
