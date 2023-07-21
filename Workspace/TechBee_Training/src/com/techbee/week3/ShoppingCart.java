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
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShoppingCart {
Scanner s = new Scanner(System.in);
Product p = new Product();
Map<String, Double> cartPriceMap = new HashMap<>();
List<Product> productObjectList = new ArrayList<>();
List<ShoppingCart> cartList = new ArrayList<>();
private long shoppingCartID = 100;
private int cartID = 0;
private double subTotal = 0;
private double total = 0;
private double salesTax = .10;
private int productQuantity = 0; 
private String productName = null; 
private String cartName = null;
private boolean isDone = false;
private double sumOfSubTotals = 0;
private double itemPrice = 0;


public ShoppingCart() {
	super();	
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
		System.out.println("4. Edit Cart ");
		System.out.println("5. Check Out ");
		System.out.println("6. Exit");		
	}
	
	Scanner s = new Scanner(System.in);	
	String sChoice = s.next();		
	
	Pattern pattern = Pattern.compile("[a-z]", Pattern.CASE_INSENSITIVE);
	Matcher matcher = pattern.matcher(sChoice);
	boolean matchFound = matcher.find();
	
	if(matchFound == true ) {
		System.out.println("Invalid Choice");
		initialization();
	}
	
	 switch(sChoice) {
	 case "1":
		viewAll();
		 break;
	 case "2":
		 add();
		 break;
	 case "3":
		 delete();
		 break;	
	 case "4":
		 editCart();
		 break;
	 case "5":
		 checkOut();
		 break;
	 case "6":		 
		 System.out.println("Thank you for shopping with us. Have a nice day!!!");
		 System.exit(0);
		 break;
		 
	default:
		 System.out.println("Invalid Choice! Please try again. \n");
		 initialization();
	}
	
	 s.close();		
}

public Product add() {		
	
	int choice = 0;
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
		System.out.println("Product Details: "+e.getProductDetails());
		System.out.printf("Product Price:"+"$"+"%.2f",e.getProductPrice());
		System.out.println();
		
		productObjectList.add(e); 
	}
	
	System.out.println("Shopping Cart Name: "+this.getCartName()); 
	
	System.out.println("Enter item number of the item you want to add to your cart and press Enter.");
	System.out.println("Type 8 then Enter if finished.");
	choice = s.nextInt();	
	
	switch(choice){
	case 0:
		do {
		index = choice;
		System.out.println("How many would you like? Maximum is 5");
		productQuantity = s.nextInt();
		
		if(productQuantity > 5) {
			System.out.println("Maximum Quantity is 5");
		}
		
		else {
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
		
		cartList.add(s0); 
		cartPriceMap.put(s0.getProductName(),s0.getSubTotal()); 		
		
		System.out.println("Cart ID: "+s0.getCartID());
		System.out.println("Name: "+s0.getProductName());
		System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
		System.out.println();
		System.out.printf("Sub Total: "+"$"+"%.2f",s0.getSubTotal());
		System.out.println();
		System.out.println("Shopping Cart Name: "+s0.getCartName());	
		}
		}
		while(productQuantity <= 0 || productQuantity > 5);		
		
		break;
	case 1:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5" );
			
			productQuantity = s.nextInt();
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}
			
			else {
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
			
			cartList.add(s1); 
			cartPriceMap.put(s1.getProductName(),s1.getSubTotal()); 		
			
			System.out.println("Cart ID: "+s1.getCartID());
			System.out.println("Name: "+s1.getProductName());
			System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s1.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s1.getCartName());			
			}
		}
			while(productQuantity <= 0 || productQuantity > 5);
		break;
	case 2:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5");
			productQuantity = s.nextInt();			
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}
			
			else {
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
			
			cartList.add(s2); 
			cartPriceMap.put(s2.getProductName(),s2.getSubTotal()); 
			
			
			System.out.println("Cart ID: "+s2.getCartID());
			System.out.println("Name: "+s2.getProductName());
			System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s2.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s2.getCartName());			
			}
		}
			while(productQuantity <= 0|| productQuantity > 5);
		break;
	case 3:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5");
			productQuantity = s.nextInt();
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}
			
			else {
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
			
			cartList.add(s3); 
			cartPriceMap.put(s3.getProductName(),s3.getSubTotal()); 
			
			
			System.out.println("Cart ID: "+s3.getCartID());
			System.out.println("Name: "+s3.getProductName());
			System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s3.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s3.getCartName());			
			}
		}
			while(productQuantity <= 0|| productQuantity > 5);
		break;
	case 4:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5");
			productQuantity = s.nextInt();			
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}			
			
			else {
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
			
			cartList.add(s4); 
			cartPriceMap.put(s4.getProductName(),s4.getSubTotal()); 			
			
			System.out.println("Cart ID: "+s4.getCartID());
			System.out.println("Name: "+s4.getProductName());
			System.out.printf("Price: "+"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s4.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s4.getCartName());			
			}
		}
			while(productQuantity <= 0|| productQuantity > 5);
		break;
	case 5:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5");
			productQuantity = s.nextInt();			
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}
			
			else {
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
			
			cartList.add(s5); 
			cartPriceMap.put(s5.getProductName(),s5.getSubTotal()); 
			
			
			System.out.println("Cart ID: "+s5.getCartID());
			System.out.println("Name: "+s5.getProductName());
			System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s5.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s5.getCartName());			
			}
		}
			while(productQuantity <= 0|| productQuantity > 5);
		break;
	case 6:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5");
			productQuantity = s.nextInt();			
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}
			
			else {
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
			
			cartList.add(s6); 
			cartPriceMap.put(s6.getProductName(),s6.getSubTotal()); 
		
			
			System.out.println("Cart ID: "+s6.getCartID());
			System.out.println("Name: "+s6.getProductName());
			System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s6.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s6.getCartName());			
			}
		}
			while(productQuantity <= 0|| productQuantity > 5);
		break;
	case 7:
		do {
			index = choice;
			System.out.println("How many would you like? Maximum is 5");
			productQuantity = s.nextInt();			
			
			if(productQuantity > 5) {
				System.out.println("Maximum Quantity is 5");
			}
			
			else {
			subTotal = productObjectList.get(choice).getProductPrice()*productQuantity;
			itemPrice = productObjectList.get(choice).getProductPrice();
			
			ShoppingCart s7= new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
					productQuantity, subTotal, cartName, index);
			
			s7.setCartID(index);
			s7.setProductName(productObjectList.get(index).getProductName());
			s7.setItemPrice(itemPrice);
			s7.setProductQuantity(productQuantity);
			s7.setSubTotal(subTotal);			
			
			cartList.add(s7); 
			cartPriceMap.put(s7.getProductName(),s7.getSubTotal()); 			
			
			System.out.println("Cart ID: "+s7.getCartID());
			System.out.println("Name: "+s7.getProductName());
			System.out.printf("Price: " +"$"+"%.2f",productObjectList.get(index).getProductPrice()); 
			System.out.println();
			System.out.printf("Sub Total: "+"$"+"%.2f",s7.getSubTotal());
			System.out.println();
			System.out.println("Shopping Cart Name: "+s7.getCartName());			
			}
		}
			while(productQuantity <= 0 || productQuantity > 5);
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
	
	if(decision.equals("yes")) {
		isDone = true;
		viewAll(); 
	}
	else if(decision.equals("no")) {
	isDone = false;	
	}
	else {
		System.out.println("Incorrect input...");
		isDone = false;
	}
	
	}while(isDone == false); 
	
	s.close();
	return p;
}

public List<ShoppingCart> viewAll(){
	
	if(cartList.size() == 0) {
		System.out.println("There is nothing in the Shopping Cart! \n");
		initialization();
	}
	else {
	System.out.println("********************Contents of Shopping Cart********************"); 
	int counter = 0;
	System.out.println("Shopping Cart Name: "+this.getCartName());
	for(ShoppingCart e: cartList ) {
		
		System.out.println("Item Number: "+counter);
		System.out.println("Product Name: "+e.getProductName());		
		System.out.println("Quantity: "+e.getProductQuantity());
		System.out.printf("Price: "+"$"+"%.2f",e.getItemPrice());
		System.out.println();
		System.out.printf("Sales Tax: "+"%.2f", salesTax);		
		System.out.println();
		
		counter++;
	}
	
	sumOfSubTotals = cartPriceMap.values().stream().mapToDouble(i ->i).sum(); 
	System.out.printf("Sub Total: "+"$"+"%.2f",sumOfSubTotals); 
	System.out.println("\n");
	
	initialization();
	s.close();
	}
	return cartList;
}

public void delete() {
	int selection = 0;	
	
	if(cartList.size() == 0) {
		System.out.println("There is nothing in the Shopping Cart \n");
	initialization();	
	}
	else {
		System.out.println("********************Contents of Shopping Cart********************"); 
		System.out.println("Shopping Cart Name: "+this.getCartName());
		int counter = 0;
		for(ShoppingCart e: cartList ) {
			
			System.out.println("Item Number: "+counter);
			System.out.println("Product Name: "+e.getProductName());		
			System.out.println("Quantity: "+e.getProductQuantity());				
			
			counter++;
		}
	System.out.println("Select Item Number of the Item to Delete then Press Enter."); 
	selection = s.nextInt();
	
	if(cartList.size() < selection) {
		System.out.println("Incorrect value, please try again! \n");
		delete();
	}
	else {
	cartPriceMap.remove(cartList.get(selection).productName); 
	cartList.remove(selection); 
	
	System.out.println("Item Deleted!");
	viewAll();
	}
	}

s.close();
}

public void editCart() {
byte selection = 0;	
	
	if(cartList.size() == 0) {
		System.out.println("There is nothing in the Shopping Cart! \n");
		initialization();
	}
	
	else {
	System.out.println("********************Contents of Shopping Cart********************"); 
	System.out.println("Shopping Cart Name: "+this.getCartName());
	int counter = 0;
	int changeAmount = 0;
	for(ShoppingCart e: cartList ) {
		
		System.out.println("Item Number: "+counter);
		System.out.println("Product Name: "+e.getProductName());		
		System.out.println("Quantity: "+e.getProductQuantity());		
		
		counter++;
	}
	
	System.out.println("Select Item Number of the quantity to change then Press Enter."); 
	selection = s.nextByte();
	System.out.println("Enter the new quantity of the item then press Enter.");
	changeAmount = s.nextInt();
	subTotal = cartList.get(selection).getItemPrice()*changeAmount;
	cartList.get(selection).productQuantity = changeAmount;
	cartPriceMap.put(cartList.get(selection).productName, subTotal);
	viewAll();
	}
}

public void checkOut() {
	
	if(cartList.size()==0) {
		System.out.println("There is nothing in the Shopping Cart \n");
		initialization();
	}
	else {
	System.out.println("To complete purchase. Please contact cashier and give Shopping Cart ID."+ "\n"+
						"Your order is ready for pickup. \n"+ "Shopping Cart ID: "+shoppingCartID); 	
	
	System.out.println("Cart Name: "+ this.getCartName());
	sumOfSubTotals = cartPriceMap.values().stream().mapToDouble(i ->i).sum(); 
	System.out.printf("Sub Total: "+"$"+"%.2f",sumOfSubTotals); 
	System.out.println();
	System.out.printf("Sales Tax: "+"%.2f", salesTax);
	System.out.println();
	total = sumOfSubTotals +(sumOfSubTotals * salesTax);
	this.setTotal(total);
	System.out.printf("Total Amount: "+"$"+"%.2f", this.getTotal());
	System.out.println("\n Have a great day!");
	shoppingCartID++;
	cartPriceMap.clear();
	cartList.clear();
	s.close();
	System.exit(0);
	}	
}

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

public long getShoppingCartID() {
	return shoppingCartID;
}

public void setShoppingCartID(long shoppingCartID) {
	this.shoppingCartID = shoppingCartID;
}

public double getTotal() {
	return total;
}

public void setTotal(double total) {
	this.total = total;
}

@Override
public String toString() {
	return "ShoppingCart [shoppingCartID=" + shoppingCartID + ", cartID=" + cartID + ", subTotal=" + subTotal
			+ ", total=" + total + ", salesTax=" + salesTax + ", productQuantity=" + productQuantity + ", productName="
			+ productName + ", cartName=" + cartName + ", isDone=" + isDone + ", sumOfSubTotals=" + sumOfSubTotals
			+ ", itemPrice=" + itemPrice + "]";
}

} // end class
