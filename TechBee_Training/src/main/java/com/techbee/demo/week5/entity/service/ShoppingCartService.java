package com.techbee.demo.week5.entity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techbee.demo.exception.ProductNotFoundException;
import com.techbee.demo.week5.entity.Product;
import com.techbee.demo.week5.entity.ShoppingCart;
import com.techbee.demo.week5.entity.repository.ShoppingCartRepository;

@Service(value = "ShoppingCartService")
public class ShoppingCartService {

	private final ShoppingCartRepository shopCartRepo;
	
	@Autowired
	public ShoppingCartService(ShoppingCartRepository shopCartRepo) {
		this.shopCartRepo = shopCartRepo;
	}
	
	public ShoppingCart addShoppingCart(ShoppingCart  shoppingCart ) {
		return shopCartRepo.saveAndFlush(shoppingCart);
	}
	
	public List<ShoppingCart > findAllShoppingCart(){
		return shopCartRepo.findAll();
	}
	
	public ShoppingCart  updateShoppingCart(ShoppingCart  shoppingCart) {
		return shopCartRepo.saveAndFlush(shoppingCart);
	}
	
	public ShoppingCart findShoppingCartItem(int cartID) {
		return shopCartRepo.findById(cartID).orElseThrow(()->
		new ProductNotFoundException("Product ID: "+cartID+ "Not Found!!!"));
	}
	
	public void deleteShoppingCartItem(int cartID) {
		shopCartRepo.deleteById(cartID);	
	}
}
