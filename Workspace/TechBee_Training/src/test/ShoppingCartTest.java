package test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import com.techbee.week3.Product;

public class ShoppingCartTest {
	
	Product p = new Product();
	
	@Test
	public void testPopulateProducts(){
		List<Product> prodListTest = new ArrayList<>();
		 p.populateProducts();		 
		 prodListTest = p.productList;
		 assertEquals(prodListTest,p.productList);
	}

}
