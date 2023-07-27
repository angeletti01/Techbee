package com.techbee.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;

import com.techbee.demo.week3.Product;
import com.techbee.demo.week3.ShoppingCart;

//@SpringBootTest
class ShoppingCartTest {
	
static Product p = new Product();
static ShoppingCart s = new ShoppingCart();
	
@Test
	void testProductItemID() {
	p.setItemID(1);
	assertEquals(p.getItemID(),1);
	}
@Test
void testProductDetails() {
	p.setProductDetails("Test");	
	assertEquals("Test",p.getProductDetails());
	}
@Test
void testProductName() {
	p.setProductName("Apple");
	assertEquals("Apple", p.getProductName());
}

@Test
void testProductPrice() {
	p.setProductPrice(0.50);
	assertEquals(0.50, p.getProductPrice());
}

@Test
void testPopulateProducts() {
	Product.populateProducts();
	assertEquals(8,Product.productList.size());	
}

@Test
void testShoppingCartSetCartID(){
	s.setCartID(1);
	assertEquals(1,s.getCartID());
}

@Test
void testShoppingCartSetCartName(){
	s.setCartName("Rico's Cart");
	assertEquals("Rico's Cart",s.getCartName());
}

@Test
void testShoppingCartDone(){
	s.setDone(false);
	assertEquals(false,s.isDone());
}

@Test
void testShoppingCartItemPrice(){
	s.setItemPrice(.50);
	assertEquals(.50,s.getItemPrice());
}

@Test
void testShoppingCartProductName(){
	s.setProductName("Test");
	assertEquals("Test", s.getProductName());
}

@Test
void testShoppingCartProductQuantity(){
	s.setProductQuantity(5);
	assertEquals(5,s.getProductQuantity());
}

@Test
void testShoppingCartSalesTax(){
	s.setSalesTax(.2);
	assertEquals(.2,s.getSalesTax());
}

@Test
void testShoppingCartSubTotal(){
	s.setSubTotal(2.20);
	assertEquals(2.20, s.getSubTotal());
}

@Test
void testShoppingCartInvoiceID(){
	s.setInvoiceID(500);
	assertEquals(500,s.getInvoiceID());
}

@Test
void testShoppingCartSumOfSubTotals(){
	s.setSumOfSubTotals(60.50);
	assertEquals(60.50, s.getSumOfSubTotals());
}

@Test
void testShoppingCart(){
	s.setTotal(100.25);
	assertEquals(100.25, s.getTotal());
}

}
