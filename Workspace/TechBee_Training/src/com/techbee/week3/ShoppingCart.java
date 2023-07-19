/**
 * Author: Rico-Kali Hayes
 * Date: 07/19/2023
 * Description: Simple Shopping Cart Java Application
 * */

package com.techbee.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
Map<Integer, Double> cartPriceMap = new HashMap<>();
List<Product> productObjectList = new ArrayList<>();
List<ShoppingCart> cartList = new ArrayList<>();
private int cartID = 0;
private double subTotal = 0;
private double salesTax = .10;
private int productQuantity = 0;
private String productName = null;
private String cartName = null;
private boolean isDone = false;

public ShoppingCart() {
	super();
	// TODO Auto-generated constructor stub
}

public ShoppingCart(String productName, int productQuantity, double subTotal, String cartName, int cartID) {
	super();
	this.productName = productName;
	this.productQuantity = productQuantity;
	this.subTotal = subTotal;
	this.cartName = cartName;
	this.cartID = cartID;
}

public Product add() {	
	
	Scanner s = new Scanner(System.in);
	Product p = new Product();
	byte choice = 0;
	String name = null;	
	String decision = null;
	int index = 0;
	
	System.out.println("Name your Shopping Cart and press Enter");
	name = s.nextLine();
	this.setCartName(name);
	
	p.populateProducts();
	do {
	System.out.println("***************************List of Products***************************");
	for(Product e: p.productList) {
		System.out.println("**************"+e.getProductName()+"**************");
		System.out.println("Item Number: "+e.getItemID());
		//System.out.println("Product Name: "+e.getProductName() );
		System.out.println("Product Details: "+e.getProductDetails());
		System.out.println("Product Price:"+"$"+e.getProductPrice()+"\n");
		
		productObjectList.add(e); // store product objects into list for processing orders
	}
	
	System.out.println(this.getCartName()); // display cart name at the top of the cart
	
	System.out.println("Enter item number of the item you want to add to your cart and press Enter");
	choice = s.nextByte();	
	
	switch(choice){
	case 0:
		do {
		index = choice;
		System.out.println("How many would you like?");
		productQuantity = s.nextInt();
		System.out.println("Storing....");
		
		subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
		
		ShoppingCart s0= new ShoppingCart(productObjectList.get(index).getProductName(),
				productQuantity, subTotal, cartName, index);
		s0.setCartID(index);
		s0.setProductName(productObjectList.get(index).getProductName());
		s0.setProductQuantity(productQuantity);
		s0.setSubTotal(subTotal);
		s0.setCartName(name);
		
		cartList.add(s0); // stores all of the items ordered (ShoppingCart Objects)
		cartPriceMap.put(s0.getCartID(),s0.getSubTotal()); // relates key:cartNumber
		System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue());
		
		System.out.println("Cart ID: "+s0.getCartID());
		System.out.println("Name: "+s0.getProductName());
		System.out.println("Price: " +productObjectList.get(index).getProductPrice());
		System.out.println("Sub Total: "+s0.getSubTotal());
		System.out.println("Cart Name: "+s0.getCartName());		
		}
		while(productQuantity <= 0);		
		
		break;
	case 1:
		
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	case 5:
		break;
	case 6:
		break;
	case 7:
		break;
		
	default:
		System.out.println("You have selected an invalid item...");
		break;
	}
	System.out.println("Are you finished shopping? Please enter yes or no then press Enter");
	
	decision = s.next().toLowerCase();
	System.out.println("Decision: "+decision); // debug
	
	if(decision.equals("yes")) {
		isDone = true;
		viewAll(); // navigate to viewAll method for list of items and sub total. 
	}
	else if(decision.equals("no")) {
	isDone = false;	
	}
	else {
		System.out.println("Incorrect input...");
		isDone = false;
	}
	
	}while(isDone == false); // continue allowing selection until finished	
	
	return p;
}

public List<Product> viewAll(){
	/* This method will only display the list of items and the sub-total. Then customer has choice
	 * to edit cart or continue to checkout*/
	
	System.out.println("Contents of Shopping Cart"); // Debugging 
	
	for(ShoppingCart e: cartList ) {
		//System.out.println(e.getCartName());
		System.out.println("Product Name: "+e.getProductName());		
		System.out.println("Quantity: "+e.getProductQuantity());
		System.out.println("Sub Total: "+e.getSubTotal());
		
	}
	return null;
}

public void delete() {
	System.out.println("You are in the delete Method!!!"); // Debugging
}

public void checkOut() {
	System.out.println("You are in the checkOut Method!!!"); // Debugging
}

/******************************Boilerplate Code******************************/
public Map<Integer, Double> getCartPriceMap() {
	return cartPriceMap;
}

public void setCartPriceMap(Map<Integer, Double> cartPriceMap) {
	this.cartPriceMap = cartPriceMap;
}

public List<Product> getProductObjectList() {
	return productObjectList;
}

public void setProductObjectList(List<Product> productObjectList) {
	this.productObjectList = productObjectList;
}

public List<ShoppingCart> getCartList() {
	return cartList;
}

public void setCartList(List<ShoppingCart> cartList) {
	this.cartList = cartList;
}

public int getCartID() {
	return cartID;
}

public void setCartID(int cartID) {
	this.cartID = cartID;
}

public double getSubTotal() {
	return subTotal;
}

public void setSubTotal(double subTotal) {
	this.subTotal = subTotal;
}

public double getSalesTax() {
	return salesTax;
}

public void setSalesTax(double salesTax) {
	this.salesTax = salesTax;
}

public int getProductQuantity() {
	return productQuantity;
}

public void setProductQuantity(int productQuantity) {
	this.productQuantity = productQuantity;
}

public String getProductName() {
	return productName;
}

public void setProductName(String productName) {
	this.productName = productName;
}

public String getCartName() {
	return cartName;
}

public void setCartName(String cartName) {
	this.cartName = cartName;
}

public boolean isDone() {
	return isDone;
}

public void setDone(boolean isDone) {
	this.isDone = isDone;
}




} // end class
