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
Scanner s = new Scanner(System.in);
Product p = new Product();
Map<String, Double> cartPriceMap = new HashMap<>();
List<Product> productObjectList = new ArrayList<>();
List<ShoppingCart> cartList = new ArrayList<>();
private int cartID = 0;
private double subTotal = 0;
private double salesTax = .10;
private int productQuantity = 0;
private String productName = null;
private String cartName = null;
private boolean isDone = false;
private double sumOfSubTotals = 0;
private double itemPrice = 0;

public ShoppingCart() {
	super();
	// TODO Auto-generated constructor stub
}

public ShoppingCart(String productName, double itemPrice,int productQuantity, double subTotal, String cartName, int cartID) {
	super();
	this.productName = productName;
	this.productQuantity = productQuantity;
	this.subTotal = subTotal;
	this.cartName = cartName;
	this.cartID = cartID;
	this.itemPrice = itemPrice;
}

public void initialization() {
	{		
		System.out.println("Please make a selection then press Enter.");
		System.out.println("1. Show Sub-Total Balance");
		System.out.println("2. Add Product");
		System.out.println("3. Delete Product");		
		System.out.println("4. Exit");		
	}
	
	//ShoppingCart sc = new ShoppingCart(); 
	//Product p = new Product();
	Scanner s = new Scanner(System.in);
	byte choice = 0;
	
	choice = s.nextByte(); 
	
	 switch(choice) {
	 case 1:
		viewAll();
		 break;
	 case 2:
		 add();
		 break;
	 case 3:
		 delete();
		 break;	
	 case 4:
		 System.out.println("Have a nice day!!!");
		 System.exit(0); // suppose to exit program
		 break;
		 
	default:
		 System.out.println("Invalid Choice...");
	 }
}

public Product add() {		
	
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
	
	System.out.println("Enter item number of the item you want to add to your cart and press Enter.");
	System.out.println("Type 8 then Enter if finished.");
	choice = s.nextByte();	
	
	switch(choice){
	case 0:
		do {
		index = choice;
		System.out.println("How many would you like?");
		productQuantity = s.nextInt();
		System.out.println("Storing....");
		
		subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
		itemPrice = productObjectList.get(choice).getProductPrice();
		
		ShoppingCart s0= new ShoppingCart(productObjectList.get(index).getProductName(),
				itemPrice,productQuantity, subTotal, cartName, index);
		s0.setCartID(index);
		s0.setProductName(productObjectList.get(index).getProductName());
		s0.setItemPrice(itemPrice);
		s0.setProductQuantity(productQuantity);
		s0.setSubTotal(subTotal);
		s0.setCartName(name);
		
		cartList.add(s0); // stores all of the items ordered (ShoppingCart Objects)
		cartPriceMap.put(s0.getProductName(),s0.getSubTotal()); // relates key:cartNumber
		System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
		
		System.out.println("Cart ID: "+s0.getCartID());
		System.out.println("Name: "+s0.getProductName());
		System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
		System.out.println("Sub Total: "+s0.getSubTotal());
		System.out.println("Cart Name: "+s0.getCartName());		
		}
		while(productQuantity <= 0);		
		
		break;
	case 1:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s1= new ShoppingCart(productObjectList.get(index).getProductName(),
					itemPrice,productQuantity, subTotal, cartName, index);
			s1.setCartID(index);
			s1.setProductName(productObjectList.get(index).getProductName());
			s1.setItemPrice(itemPrice);
			s1.setProductQuantity(productQuantity);
			s1.setSubTotal(subTotal);
			s1.setCartName(name);
			
			cartList.add(s1); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s1.getProductName(),s1.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s1.getCartID());
			System.out.println("Name: "+s1.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s1.getSubTotal());
			System.out.println("Cart Name: "+s1.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 2:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s2= new ShoppingCart(productObjectList.get(index).getProductName(),itemPrice,
					productQuantity, subTotal, cartName, index);
			s2.setCartID(index);
			s2.setProductName(productObjectList.get(index).getProductName());
			s2.setItemPrice(itemPrice);
			s2.setProductQuantity(productQuantity);
			s2.setSubTotal(subTotal);
			s2.setCartName(name);
			
			cartList.add(s2); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s2.getProductName(),s2.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s2.getCartID());
			System.out.println("Name: "+s2.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s2.getSubTotal());
			System.out.println("Cart Name: "+s2.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 3:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s3= new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
					productQuantity, subTotal, cartName, index);
			s3.setCartID(index);
			s3.setProductName(productObjectList.get(index).getProductName());
			s3.setItemPrice(itemPrice);
			s3.setProductQuantity(productQuantity);
			s3.setSubTotal(subTotal);
			s3.setCartName(name);
			
			cartList.add(s3); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s3.getProductName(),s3.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s3.getCartID());
			System.out.println("Name: "+s3.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s3.getSubTotal());
			System.out.println("Cart Name: "+s3.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 4:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s4= new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
					productQuantity, subTotal, cartName, index);
			s4.setCartID(index);
			s4.setProductName(productObjectList.get(index).getProductName());
			s4.setItemPrice(itemPrice);
			s4.setProductQuantity(productQuantity);
			s4.setSubTotal(subTotal);
			s4.setCartName(name);
			
			cartList.add(s4); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s4.getProductName(),s4.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s4.getCartID());
			System.out.println("Name: "+s4.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s4.getSubTotal());
			System.out.println("Cart Name: "+s4.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 5:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s5= new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
					productQuantity, subTotal, cartName, index);
			s5.setCartID(index);
			s5.setProductName(productObjectList.get(index).getProductName());
			s5.setItemPrice(itemPrice);
			s5.setProductQuantity(productQuantity);
			s5.setSubTotal(subTotal);
			s5.setCartName(name);
			
			cartList.add(s5); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s5.getProductName(),s5.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s5.getCartID());
			System.out.println("Name: "+s5.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s5.getSubTotal());
			System.out.println("Cart Name: "+s5.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 6:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s6= new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
					productQuantity, subTotal, cartName, index);
			
			s6.setCartID(index);
			s6.setProductName(productObjectList.get(index).getProductName());
			s6.setProductQuantity(productQuantity);
			s6.setItemPrice(itemPrice);
			s6.setSubTotal(subTotal);
			s6.setCartName(name);
			
			cartList.add(s6); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s6.getProductName(),s6.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s6.getCartID());
			System.out.println("Name: "+s6.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s6.getSubTotal());
			System.out.println("Cart Name: "+s6.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 7:
		do {
			index = choice;
			System.out.println("How many would you like?");
			productQuantity = s.nextInt();
			System.out.println("Storing....");
			
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s7= new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
					productQuantity, subTotal, cartName, index);
			
			s7.setCartID(index);
			s7.setProductName(productObjectList.get(index).getProductName());
			s7.setItemPrice(itemPrice);
			s7.setProductQuantity(productQuantity);
			s7.setSubTotal(subTotal);
			s7.setCartName(name);
			
			cartList.add(s7); // stores all of the items ordered (ShoppingCart Objects)
			cartPriceMap.put(s7.getProductName(),s7.getSubTotal()); // relates key:cartNumber
			System.out.println("CartPriceMap Value: " +cartPriceMap.get(index).doubleValue()); // debug
			
			System.out.println("Cart ID: "+s7.getCartID());
			System.out.println("Name: "+s7.getProductName());
			System.out.println("Price: " +productObjectList.get(index).getProductPrice()); //WARNING: !! Need printf and formatting for second decimal place !!
			System.out.println("Sub Total: "+s7.getSubTotal());
			System.out.println("Cart Name: "+s7.getCartName());			
			}
			while(productQuantity <= 0);
		break;
	case 8:
		viewAll();
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
	
	s.close();
	return p;
}

public List<ShoppingCart> viewAll(){
	/* This method will only display the list of items and the sub-total. Then customer has choice
	 * to edit cart or continue to checkout*/
	
	System.out.println("********************Contents of Shopping Cart********************"); // Debugging 
	int counter = 0;
	for(ShoppingCart e: cartList ) {
		
		System.out.println("Item Number: "+counter);
		System.out.println("Product Name: "+e.getProductName());		
		System.out.println("Quantity: "+e.getProductQuantity());
		System.out.println("Price: "+e.getItemPrice()+"\n");
		
		//System.out.println("Sub Total: "+"$"+e.getSubTotal()); //WARNING: !! Need printf and formatting for second decimal place !!
		counter++;
	}
	sumOfSubTotals = cartPriceMap.values().stream().mapToDouble(i ->i).sum(); // the the sums of the sub totals
	System.out.println("Sub Total: "+"$"+sumOfSubTotals+"\n"); 
	
	//s.wait(100); // add delay
	
	initialization();
	s.close();
	return cartList;
}

public void delete() {
	byte selection = 0;
	
	
	System.out.println("********************Contents of Shopping Cart********************"); 
	int counter = 0;
	for(ShoppingCart e: cartList ) {
		
		System.out.println("Item Number: "+counter);
		System.out.println("Product Name: "+e.getProductName());		
		System.out.println("Quantity: "+e.getProductQuantity());
		//System.out.println("Price: "+e.getItemPrice()+"\n");
		
		//System.out.println("Sub Total: "+"$"+e.getSubTotal()); //WARNING: !! Need printf and formatting for second decimal place !!
		counter++;
	}
	System.out.println("Select Item Number of the Item to Delete then Press Enter."); 
	selection = s.nextByte();	
	cartPriceMap.remove(selection);
	cartList.remove(selection); // remove selected element
	
	System.out.println("Item Deleted!");
	viewAll();
	
for(ShoppingCart e: cartList ) {
		
		System.out.println("Item Number: "+counter);
		System.out.println("Product Name: "+e.getProductName());		
		System.out.println("Quantity: "+e.getProductQuantity());
		//System.out.println("Price: "+e.getItemPrice()+"\n");
		
		//System.out.println("Sub Total: "+"$"+e.getSubTotal()); //WARNING: !! Need printf and formatting for second decimal place !!
		counter++;
	}

	
s.close();
}

public void checkOut() {
	System.out.println("You are in the checkOut Method!!!"); // Debugging
	
	s.close();
}

/******************************Boilerplate Code******************************/
public Map<String, Double> getCartPriceMap() {
	return cartPriceMap;
}

public void setCartPriceMap(Map<String, Double> cartPriceMap) {
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

public double getSumOfSubTotals() {
	return sumOfSubTotals;
}

public void setSumOfSubTotals(double sumOfSubTotals) {
	this.sumOfSubTotals = sumOfSubTotals;
}

public double getItemPrice() {
	return itemPrice;
}

public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}

@Override
public String toString() {
	return "ShoppingCart [cartPriceMap=" + cartPriceMap + ", productObjectList=" + productObjectList + ", cartList="
			+ cartList + ", cartID=" + cartID + ", subTotal=" + subTotal + ", salesTax=" + salesTax
			+ ", productQuantity=" + productQuantity + ", productName=" + productName + ", cartName=" + cartName
			+ ", isDone=" + isDone + ", sumOfSubTotals=" + sumOfSubTotals + ", itemPrice=" + itemPrice + "]";
}

} // end class
