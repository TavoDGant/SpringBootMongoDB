package com.tdgames.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tdgames.entity.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String>{

	//More methods to find Books, Price and Name
	List<Products> findByPrice(Double price);
	
	List<Products> findByNameContaining(String name);
	
}
