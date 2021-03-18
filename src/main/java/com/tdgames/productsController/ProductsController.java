package com.tdgames.productsController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tdgames.entity.Products;
import com.tdgames.service.ProductsService;

@RestController
public class ProductsController {

	@Autowired
	private ProductsService productsService;
	
	@PostMapping("/saveProduct")
	public String saveProduct(@RequestBody Products products) {
		productsService.saveProduct(products);
		return ""+HttpStatus.OK;
	}
	
	@GetMapping("/allProducts")
	public List<Products> allProducts(){
		return productsService.showAll();
	}
	
	@PutMapping("/updateProduct")
	public String updateProduct(@RequestBody Products products) {
		productsService.updateProduct(products);
		return "" + HttpStatus.OK;
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable String id) {
		productsService.deleteProduct(id.toString());
		return ""+HttpStatus.OK;
	}
	
}
