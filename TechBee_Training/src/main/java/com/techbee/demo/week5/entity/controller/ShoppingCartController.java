package com.techbee.demo.week5.entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techbee.demo.week5.entity.Product;
import com.techbee.demo.week5.entity.ShoppingCart;
import com.techbee.demo.week5.entity.service.ShoppingCartService;

@RestController(value = "ShoppingCartController")
public class ShoppingCartController {

	private final ShoppingCartService shopCartServ;
	
	@Autowired
	public ShoppingCartController(ShoppingCartService shopCartServ) {
		this.shopCartServ = shopCartServ;
	}
	
	 @GetMapping("/find-all-cart-items")
	 public ResponseEntity<List<ShoppingCart>> getAllShoppingCartItems() {
	 List<ShoppingCart> shoppingCart = shopCartServ.findAllShoppingCart();
	 return new ResponseEntity<>(shoppingCart,HttpStatus.OK);
	 }
	 
	 @GetMapping("find-cart-items-by-id")
	 public ResponseEntity<ShoppingCart> findShoppingCartItemsById(@RequestParam("cartItemID") int cartItemID){
		 ShoppingCart shoppingCart = shopCartServ.findShoppingCartItemById(cartItemID);
		 return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
	 }
	 
	 @PostMapping("/add-cart-item")
	 public ResponseEntity<ShoppingCart> addShoppingCartItem(@RequestBody ShoppingCart shoppingCart){
	 ShoppingCart addShoppingCartItem = shopCartServ.addShoppingCartItem(shoppingCart);
	 return new ResponseEntity<>(addShoppingCartItem,HttpStatus.CREATED);
	 }
	 
	 @PutMapping("/update-cart")
	 public ResponseEntity<ShoppingCart> updateShoppingCart(@RequestBody ShoppingCart shoppingCart, @RequestParam ("cartItemID") int cartItemID){
		 shopCartServ.deleteShoppingCartItem(cartItemID);
		 //product.setItemID(itemID); // not updating itemID in DB, possibly because auto generated
		 ShoppingCart updateItem = shopCartServ.updateShoppingCart(shoppingCart);
		 return new ResponseEntity<>(updateItem,HttpStatus.OK);
	 }
	 
	 @DeleteMapping("/delete-cart-item")
	 public ResponseEntity<ShoppingCart> deleteShoppingCartItem(@RequestParam ("cartItemID") int cartItemID){
		shopCartServ.deleteShoppingCartItem(cartItemID);
		return new ResponseEntity<>(HttpStatus.OK);
	 }
	
}
