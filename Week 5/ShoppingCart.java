/**
 * Author: Rico-Kali Hayes
 * Date: 07/19/2023
 * Description: Simple Shopping Cart Java Application
 * */

package com.techbee.demo.week5.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart", schema="techbee")
public class ShoppingCart implements Serializable {
	
	private static final long serialVersionUID = 1L;		
	
	@Id
	@GeneratedValue(generator = "cart_item_id_seq", strategy = GenerationType.IDENTITY)
	@Column(name = "cart_item_id")
	private int cartItemID = 0;	
	@Column(name = "invoice_id")
	private long invoiceID = 0;		
	@Column(name = "total")
	private double total = 0;	
	@Column(name = "salesTax")
	private double salesTax = .10;	
	@Column(name = "cart_name")
	private String cartName = null;	
	@Column(name = "sub_total")
	private double subTotal = 0;	
	@Column(name = "item_price")
	private double itemPrice = 0;	
	@Column(name = "quantity")
	private int productQuantity = 0;	
	@Column(name = "product_name")
	private String productName = null;	
	
	@OneToOne
	@PrimaryKeyJoinColumn(name = "cart_item_id")
	Product product;
	
	public ShoppingCart() {
		super();
	}

	public ShoppingCart(String productName, double itemPrice, int productQuantity, double subTotal, String cartName,
			int cartItemID, int invoiceID, double salesTax, int total) {
		super();
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.subTotal = subTotal;
		this.cartName = cartName;
		this.cartItemID = cartItemID;
		this.itemPrice = itemPrice;
		this.invoiceID = invoiceID;
		this.salesTax = salesTax;
		this.total = total;
	}	
	
	
	public int getCartID() {
		return cartItemID;
	}

	public void setCartID(int cartID) {
		this.cartItemID = cartID;
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
		return "ShoppingCart [cartItemID=" + cartItemID + ", invoiceID=" + invoiceID + ", total=" + total + ", salesTax="
				+ salesTax + ", cartName=" + cartName + ", subTotal=" + subTotal + ", itemPrice=" + itemPrice
				+ ", productQuantity=" + productQuantity + ", productName=" + productName + ", product=" + product
				+ "]";
	}	

} // end class
