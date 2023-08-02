/**
 * Author: Rico-Kali Hayes
 * Date: 07/19/2023
 * Description: Simple Shopping Cart Java Application
 * */

package com.techbee.demo.week5.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

@Entity
@Table(name="product", schema="techbee")
public class Product implements Serializable {
	
public static List<Product> productList = new ArrayList<>();
private static final Logger log = LogManager.getLogger(Product.class);
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(generator = "item_id_seq", strategy = GenerationType.IDENTITY)
@Column(name="item_id")
private int itemID = 0;

@Column(name="product_name")
private String productName = null;

@Column(name="product_price")
private double productPrice = 0;

@Column(name="product_details")
private String productDetails = null;

@OneToOne(mappedBy = "product")
ShoppingCart shoppingCart;

public Product() {
	super();	
}

public Product(int itemID,String productName, double productPrice, String productDetails) {
	this.itemID = itemID;
	this.productDetails = productDetails;
	this.productName = productName;
	this.productPrice = productPrice;
}


/******************************Boilerplate Code******************************/
public int getItemID() {
	return itemID;
}
public void setItemID(int itemID) {
	this.itemID = itemID;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public String getProductDetails() {
	return productDetails;
}
public void setProductDetails(String productDetails) {
	this.productDetails = productDetails;
}

}
