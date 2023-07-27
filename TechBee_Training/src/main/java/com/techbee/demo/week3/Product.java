/**
 * Author: Rico-Kali Hayes
 * Date: 07/19/2023
 * Description: Simple Shopping Cart Java Application
 * */

package com.techbee.demo.week3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product", schema="techbee")
public class Product implements Serializable {
	
public static List<Product> productList = new ArrayList<>();

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(generator = "item_id_seq", strategy = GenerationType.AUTO)
@Column(name="item_id")
private int itemID = 0;

@Column(name="product_name")
private String productName = null;

@Column(name="product_price")
private double productPrice = 0;

@Column(name="product_details")
private String productDetails = null;

public Product() {
	super();
}
public Product(int itemID,String productName, double productPrice, String productDetails) {
	this.itemID = itemID;
	this.productDetails = productDetails;
	this.productName = productName;
	this.productPrice = productPrice;
}

public void populateProducts() {
	
	Product p0 = new Product(0," Gala Apple", .25, " A cross between Kidd�s Orange Red and Golden Delicious, originated in New Zealand!");
	Product p1 = new Product(1," Golden Delicious Apple", .25, " Yellow with an occasional pink blush, Golden Delicious is Apple Lite loved by those who prefer a mild, sweet flavor.");
	Product p2 = new Product(2," Granny Smith Apple", .10, " Grannies are known for their distinctive green flesh which sometimes bears a red blush and their very tart flavor.");
	Product p3 = new Product(3," Honey Crisp Apple", .35, " This honey of an apple has a honeyed, mild flavor and a crispness deemed explosive.");
	Product p4 = new Product(4," McIntosh Apple", .10, " Juicy, tangy, tart McIntosh has a tender, white flesh. It is best used for snacking and applesauce.");
	Product p5 = new Product(5," Red Delicious Apple", .15, " This sweet, crispy, juicy apple varies in color from striped red to solid midnight red.");
	Product p6 = new Product(6," Cripps Pink / Pink Lady Apple", .35, " Developed in Western Australia, Cripps Pink is a cross of Golden Delicious and Lady Williams.");
	Product p7 = new Product(7," Empire Apple", .35, " This crisp, juicy apple has a delightful sweet-tart flavor and creamy white flesh, making it a good all-purpose apple.");
	
	productList.add(p0);
	productList.add(p1);
	productList.add(p2);
	productList.add(p3);
	productList.add(p4);
	productList.add(p5);
	productList.add(p6);
	productList.add(p7);
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
