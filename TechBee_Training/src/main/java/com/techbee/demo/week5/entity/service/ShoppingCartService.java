package com.techbee.demo.week5.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.demo.exception.ProductNotFoundException;
import com.techbee.demo.week5.entity.ShoppingCart;
import com.techbee.demo.week5.entity.repository.ShoppingCartRepository;

@Service(value = "ShoppingCartService")
public class ShoppingCartService {

	private final ShoppingCartRepository shopCartRepo;
	
	@Autowired
	public ShoppingCartService(ShoppingCartRepository shopCartRepo) {
		this.shopCartRepo = shopCartRepo;
	}
	
	public ShoppingCart addShoppingCartItem(ShoppingCart  shoppingCart ) {
		return shopCartRepo.saveAndFlush(shoppingCart);
	}
	
	public List<ShoppingCart> findAllShoppingCart(){
		return shopCartRepo.findAll();
	}
	
	public ShoppingCart  updateShoppingCart(ShoppingCart  shoppingCart) {
		return shopCartRepo.saveAndFlush(shoppingCart);
	}
	
	public ShoppingCart findShoppingCartItemById(int cartItemID) {
		return shopCartRepo.findById(cartItemID).orElseThrow(()->
		new ProductNotFoundException("Shopping Cart Item ID: "+cartItemID+ "Not Found!!!"));
	}
	
	public void deleteShoppingCartItem(int cartItemID) {
		shopCartRepo.deleteById(cartItemID);	
	}
}
