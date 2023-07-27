/**
 * Author: Rico-Kali Hayes
 * Date: 07/19/2023
 * Description: Simple Shopping Cart Java Application
 * */

package com.techbee.demo.week3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;  
import org.apache.log4j.LogManager;  
import org.apache.log4j.Logger;

public class ShoppingCart {
	
	static Scanner s = new Scanner(System.in);	
	static Map<String, Double> cartPriceMap = new HashMap<>();
	static List<Product> productObjectList = new ArrayList<>();
	static List<ShoppingCart> cartList = new ArrayList<>();
	private static final Logger log = LogManager.getLogger(ShoppingCart.class);
	static String sChoice = null;
	static String choice = null;
	static String decision = null;
	static int selection = 0;
	
	private long invoiceID = 100;
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

	public ShoppingCart(String productName, double itemPrice, int productQuantity, double subTotal, String cartName,
			int cartID) {
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
			log.info("Please make a selection then press Enter.");
			log.info("1. Show Sub-Total Balance");
			log.info("2. Add Product");
			log.info("3. Delete Product");
			log.info("4. Edit Cart ");
			log.info("5. Check Out ");
			log.info("6. Exit");

		}
		
		sChoice = s.next();

		switch (sChoice) {
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
			log.info("Thank you for shopping with us. Have a nice day!!!");
			//System.out.println("Thank you for shopping with us. Have a nice day!!!");
			System.exit(0);
			break;

		default:
			log.info("Invalid Choice! Please try again. \n");
			//System.out.println("Invalid Choice! Please try again. \n");
			initialization();
		}
		s.close();
	}

	public void add() throws NumberFormatException, InputMismatchException {
		
		String name = null;		
		int index = 0;

		System.out.println("Name your Shopping Cart and press Enter");
		name = s.nextLine();
		this.setCartName(name);
		System.out.println("Shopping Cart Name: " + this.getCartName());
		Product.populateProducts();

		do {
			System.out.println("***************************List of Products***************************");
			for (Product e : Product.productList) {
				System.out.println("**************" + e.getProductName() + "**************");
				System.out.println("Item Number: " + e.getItemID());
				System.out.println("Product Details: " + e.getProductDetails());
				System.out.printf("Product Price:" + "$" + "%.2f", e.getProductPrice());
				System.out.println();

				productObjectList.add(e);
			}		

			System.out.println("Enter item number of the item you want to add to your cart and press Enter.");
			System.out.println("Type 8 then Enter if finished.");

			try {
				choice = s.next();
				index = Integer.parseInt(choice);
			} catch (NumberFormatException n) {
				add();
				n.printStackTrace();				
			}
			
				switch (choice) {
				case "0":
					do {

						System.out.println("How many would you like? Maximum is 5");
						try {
						productQuantity = s.nextInt();
						}
						catch(InputMismatchException i) 
						{
							System.out.println("Invalid Input!");
							add();
							i.printStackTrace();
						}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s0 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s0);
							cartPriceMap.put(s0.getProductName(), s0.getSubTotal());

							System.out.println("Cart ID: " + s0.getCartID());
							System.out.println("Name: " + s0.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s0.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);

					break;
				case "1":
					do {
						System.out.println("How many would you like? Maximum is 5");

						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s1 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s1);
							cartPriceMap.put(s1.getProductName(), s1.getSubTotal());

							System.out.println("Cart ID: " + s1.getCartID());
							System.out.println("Name: " + s1.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s1.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "2":
					do {
						System.out.println("How many would you like? Maximum is 5");
						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s2 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s2);
							cartPriceMap.put(s2.getProductName(), s2.getSubTotal());

							System.out.println("Cart ID: " + s2.getCartID());
							System.out.println("Name: " + s2.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s2.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "3":
					do {
						System.out.println("How many would you like? Maximum is 5");
						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s3 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s3);
							cartPriceMap.put(s3.getProductName(), s3.getSubTotal());

							System.out.println("Cart ID: " + s3.getCartID());
							System.out.println("Name: " + s3.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s3.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "4":
					do {
						System.out.println("How many would you like? Maximum is 5");
						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s4 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s4);
							cartPriceMap.put(s4.getProductName(), s4.getSubTotal());

							System.out.println("Cart ID: " + s4.getCartID());
							System.out.println("Name: " + s4.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s4.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "5":
					do {
						System.out.println("How many would you like? Maximum is 5");
						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s5 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s5);
							cartPriceMap.put(s5.getProductName(), s5.getSubTotal());

							System.out.println("Cart ID: " + s5.getCartID());
							System.out.println("Name: " + s5.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s5.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "6":
					do {
						System.out.println("How many would you like? Maximum is 5");
						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s6 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s6);
							cartPriceMap.put(s6.getProductName(), s6.getSubTotal());

							System.out.println("Cart ID: " + s6.getCartID());
							System.out.println("Name: " + s6.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s6.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "7":
					do {
						System.out.println("How many would you like? Maximum is 5");
						try {
							productQuantity = s.nextInt();
							}
							catch(InputMismatchException i) 
							{
								System.out.println("Invalid Input!");
								add();
								i.printStackTrace();
							}

						if (productQuantity > 5) {
							System.out.println("Maximum Quantity is 5");
						}

						else {
							subTotal = productObjectList.get(index).getProductPrice() * productQuantity;
							itemPrice = productObjectList.get(index).getProductPrice();

							ShoppingCart s7 = new ShoppingCart(productObjectList.get(index).getProductName(), itemPrice,
									productQuantity, subTotal, cartName, index);

							cartList.add(s7);
							cartPriceMap.put(s7.getProductName(), s7.getSubTotal());

							System.out.println("Cart ID: " + s7.getCartID());
							System.out.println("Name: " + s7.getProductName());
							System.out.printf("Price: " + "$" + "%.2f", productObjectList.get(index).getProductPrice());
							System.out.println();
							System.out.printf("Sub Total: " + "$" + "%.2f", s7.getSubTotal());
							System.out.println();
							
						}
					} while (productQuantity <= 0 || productQuantity > 5);
					break;
				case "8":
					viewAll();
					break;

				default:
					System.out.println("You have selected an invalid item...");
					break;
				}

				System.out.println("Are you finished shopping? Please enter yes or no then press Enter");

				decision = s.next().toLowerCase();

				if (decision.equals("yes")) {
					isDone = true;
					viewAll();
				} else if (decision.equals("no")) {
					isDone = false;
				} else {
					System.out.println("Incorrect input...");
					isDone = false;
				}
			
		} while (isDone == false);

		s.close();		
	}

	public List<ShoppingCart> viewAll() {

		if (cartList.isEmpty()) {
			System.out.println("There is nothing in the Shopping Cart! \n");
			initialization();
		} 
		else {
			System.out.println("********************Contents of Shopping Cart********************");
			int counter = 0;
			System.out.println("Shopping Cart Name: " + this.getCartName());
			for (ShoppingCart e : cartList) {

				System.out.println("Item Number: " + counter);
				System.out.println("Product Name: " + e.getProductName());
				System.out.println("Quantity: " + e.getProductQuantity());
				System.out.printf("Price: " + "$" + "%.2f", e.getItemPrice());
				System.out.println();
				System.out.printf("Sales Tax: " + "%.2f", salesTax);
				System.out.println("\n");

				counter++;
			}

			sumOfSubTotals = cartPriceMap.values().stream().mapToDouble(i -> i).sum();

			System.out.printf("Sub Total: " + "$" + "%.2f", sumOfSubTotals);
			System.out.println("\n");

			initialization();
			s.close();
		}
		return cartList;
	}

	public void delete() throws InputMismatchException,NumberFormatException,IndexOutOfBoundsException {
			selection = 0;
		int counter = 0;
		
		if (cartList.isEmpty()) {
			System.out.println("There is nothing in the Shopping Cart \n");
			initialization();
		} else {
			System.out.println("********************Contents of Shopping Cart********************");
			System.out.println("Shopping Cart Name: " + this.getCartName());
			
			for (ShoppingCart e : cartList) {

				System.out.println("Item Number: " + counter);
				System.out.println("Product Name: " + e.getProductName());
				System.out.println("Quantity: " + e.getProductQuantity());

				counter++;
			}	
			
				System.out.println("Select Item Number of the Item to Delete then Press Enter.");
				try {
				selection = s.nextInt();
				}
				catch (InputMismatchException|NumberFormatException|IndexOutOfBoundsException e) {
					System.out.println("Invalid Choice!");
					initialization();
					e.printStackTrace();
				}
				
				if (selection > cartList.size() || selection < 0) {
					System.out.println("Incorrect value, please try again! \n");
					initialization();
				} 
				else {
					do {

						cartPriceMap.remove(cartList.get(selection).productName);
						cartList.remove(selection);

						System.out.println("Item Deleted!");
						viewAll();

					} while (selection > cartList.size() || selection < 0);
				}			 
		}
		s.close();
	}

	public void editCart() throws InputMismatchException,IndexOutOfBoundsException {
		 selection = 0;
		int counter = 0;
		int changeAmount = 0;
		
		if (cartList.isEmpty()) {
			System.out.println("There is nothing in the Shopping Cart! \n");
			initialization();
		}

		else {
			System.out.println("********************Contents of Shopping Cart********************");
			System.out.println("Shopping Cart Name: " + cartName);
			
			for (ShoppingCart e : cartList) {

				System.out.println("Item Number: " + counter);
				System.out.println("Product Name: " + e.getProductName());
				System.out.println("Quantity: " + e.getProductQuantity());

				counter++;
			}
			try {
				System.out.println("Select Item Number of the quantity to change then Press Enter.");
				selection = s.nextInt();
			} catch (IndexOutOfBoundsException|InputMismatchException  i) {
				System.out.println("Invalid Selection!");				
				add();
				i.printStackTrace();
			}
				System.out.println("Enter the new quantity of the item then press Enter.");
				changeAmount = s.nextInt();
				subTotal = cartList.get(selection).getItemPrice() * changeAmount;
				cartList.get(selection).productQuantity = changeAmount;
				cartPriceMap.put(cartList.get(selection).productName, subTotal);
				viewAll();			
		}
	}

	public void checkOut() {

		if (cartList.isEmpty()) {
			System.out.println("There is nothing in the Shopping Cart \n");
			initialization();
		} else {
			System.out.println("To complete purchase. Please contact cashier and give Shopping Cart ID." + "\n"
					+ "Your order is ready for pickup. \n" + "Shopping Cart ID: " + invoiceID);

			System.out.println("Cart Name: " + this.getCartName());
			sumOfSubTotals = cartPriceMap.values().stream().mapToDouble(i -> i).sum();
			System.out.printf("Sub Total: " + "$" + "%.2f", sumOfSubTotals);
			System.out.println();
			System.out.printf("Sales Tax: " + "%.2f", salesTax);
			System.out.println();
			total = sumOfSubTotals + (sumOfSubTotals * salesTax);
			this.setTotal(total);
			System.out.printf("Total Amount: " + "$" + "%.2f", this.getTotal());
			System.out.println("\n Have a great day!");
			invoiceID++;
			cartPriceMap.clear();
			cartList.clear();
			s.close();
			System.exit(0);
		}
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

	public long getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(long invoiceID) {
		this.invoiceID = invoiceID;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ShoppingCart [shoppingCartID=" + invoiceID + "cartID=" + cartID + ", subTotal=" + subTotal
				+ ", total=" + total + ", salesTax=" + salesTax + ", productQuantity=" + productQuantity
				+ ", productName=" + productName + ", cartName=" + cartName + ", isDone=" + isDone + ", sumOfSubTotals="
				+ sumOfSubTotals + ", itemPrice=" + itemPrice + "]";
	}

} // end class
