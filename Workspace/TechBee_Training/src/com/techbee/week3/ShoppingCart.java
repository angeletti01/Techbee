package com.techbee.week3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ShoppingCart {
	Map<Product, Integer> productSelectionMap = new HashMap<>();
private double subTotal = 0;
private double salesTax = .10;
private int productQuantity = 0;
private String cartName = null;


public Product add() {	
	
	Scanner s = new Scanner(System.in);
	Product p = new Product();
	byte choice = 0;
	String name = null;
	System.out.println("Name your Shopping Cart and press Enter");
	name = s.nextLine();
	this.setCartName(name);
	
	p.populateProducts();
	
	for(Product e: p.productList) {
		System.out.println("Item Number: "+e.getItemID());
		System.out.println("Product Name: "+e.getProductName() );
		System.out.println("Product Details: "+e.getProductDetails());
		System.out.println("Product Price:"+"$"+e.getProductPrice()+"\n");		
	}
	System.out.println(this.getCartName());
	System.out.println("Enter item number of item you want to add to your cart and press Enter");
	
	System.out.println("Enter quantity of item");
	switch(choice){
	case 1:
		System.out.println("");
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
	case 8:
		break;
		
	default:
		System.out.println("You have selected an invalid item...");
		break;
	}
	
	
	return null;
}

public void delete() {
	
}

public List<Product> viewAll(){
	return null;
}

public void checkOut() {
	
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

public String getCartName() {
	return cartName;
}

public void setCartName(String cartName) {
	this.cartName = cartName;
}

@Override
public int hashCode() {
	return Objects.hash(cartName, productQuantity, salesTax, subTotal);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	ShoppingCart other = (ShoppingCart) obj;
	return Objects.equals(cartName, other.cartName) && productQuantity == other.productQuantity
			&& Double.doubleToLongBits(salesTax) == Double.doubleToLongBits(other.salesTax)
			&& Double.doubleToLongBits(subTotal) == Double.doubleToLongBits(other.subTotal);
}

@Override
public String toString() {
	return "ShoppingCart [subTotal=" + subTotal + ", salesTax=" + salesTax + ", productQuantity=" + productQuantity
			+ ", cartName=" + cartName + "]";
}

} // end class
