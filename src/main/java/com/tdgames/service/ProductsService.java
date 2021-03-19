package com.tdgames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tdgames.entity.Products;
import com.tdgames.repository.ProductsRepository;

@Service
public class ProductsService {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private IDIncrementService idIncrementService;
	
	public void saveProduct(Products products) {
		products.setId(idIncrementService.generateSequence(Products.SEQUENCE_NAME));//This is to add an autoincrement ID
		products.setName(products.getName().toLowerCase());
		products.setDescription(products.getDescription().toLowerCase());
		productsRepository.save(products);
		System.out.println("Guardado");
	}
	
	public List<Products> showAll(){
		return productsRepository.findAll();
	}
	
	public void updateProduct(Products products){
		productsRepository.save(products);
	}
	
	public void deleteProduct(String id) {
		productsRepository.deleteById(id);
	}
	
	public List<Products> findByNameContaining(String name) {
		String nameLower = name.toLowerCase();
		return productsRepository.findByNameContaining(nameLower);
	}
	
	public List<Products> findByPrice(Double price) {
		return productsRepository.findByPrice(price);
	}
}
