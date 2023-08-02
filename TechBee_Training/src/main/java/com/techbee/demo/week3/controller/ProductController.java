package com.techbee.demo.week3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.demo.week3.Product;
import com.techbee.demo.week3.service.ProductService;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/shopping-cart")
public class ProductController {

	private final ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
	this.productService = productService;	
	}
	
	 @GetMapping("/find-all-products")
	 public ResponseEntity<List<Product>> getAllProducts() {
	 List<Product> product = productService.findAllProducts();
	 return new ResponseEntity<>(product,HttpStatus.OK);
	 }
	 
	 @GetMapping("find-product-by-id")
	 public ResponseEntity<Product> findProductById(@RequestParam("itemID") int itemID){
		 Product product = productService.findProductById(itemID);
		 return new ResponseEntity<>(product, HttpStatus.OK);
	 }
	 
	 @PostMapping("/add-product")
	 public ResponseEntity<Product> addProduct(@RequestBody Product product){
	 Product newProduct = productService.addProduct(product);
	 return new ResponseEntity<>(newProduct,HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/update-product")
	 public ResponseEntity<Product> updateProduct(@RequestBody Product product, @RequestParam ("itemID") int itemID){
		 productService.deleteProduct(itemID);
		 //product.setItemID(itemID); // not updating itemID in DB, possibly because auto generated
		 Product updateProduct = productService.updateProduct(product);
		 return new ResponseEntity<>(updateProduct,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete-product")
	 public ResponseEntity<Product> deleteProduct(@RequestParam ("itemID") int itemID){
		productService.deleteProduct(itemID);
		return new ResponseEntity<>(HttpStatus.OK);
	 }
	 
}
