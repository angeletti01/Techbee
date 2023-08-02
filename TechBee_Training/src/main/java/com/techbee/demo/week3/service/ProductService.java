package com.techbee.demo.week3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.demo.exception.ProductNotFoundException;
import com.techbee.demo.week3.Product;
import com.techbee.demo.week3.repository.ProductRepository;

@Service(value = "ProductService")
public class ProductService {
	
	private final ProductRepository prodRepo;
	
	@Autowired
	ProductService(ProductRepository prodRepo){
		this.prodRepo = prodRepo;
	}
	
	public Product addProduct(Product product) {
		return prodRepo.saveAndFlush(product);
	}
	
	public List<Product> findAllProducts(){
		return prodRepo.findAll();
	}
	
	public Product updateProduct(Product product) {
		return prodRepo.saveAndFlush(product);
	}
	
	public Product findProductById(int itemID) {
		return prodRepo.findById(itemID).orElseThrow(()->
		new ProductNotFoundException("Product ID: "+itemID+ "Not Found!!!"));
	}
	
	public void deleteProduct(int itemID) {
	prodRepo.deleteById(itemID);	
	}

}
