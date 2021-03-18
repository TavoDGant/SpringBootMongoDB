package com.tdgames.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tdgames.entity.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String>{

}
