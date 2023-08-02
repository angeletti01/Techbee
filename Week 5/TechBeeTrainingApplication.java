package com.techbee.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techbee.demo.week5.entity.Product;
import com.techbee.demo.week5.entity.service.ProductService;

@SpringBootApplication
public class TechBeeTrainingApplication {
	
	private static ProductService ps;
	
	@Autowired
	TechBeeTrainingApplication(ProductService ps){
		this.ps = ps;
	}
	
	public static void createEntities() {
		Product p0 = new Product(1," Gala Apple", .25, " A cross between Kidd's Orange Red and Golden Delicious, originated in New Zealand!");
		Product p1 = new Product(2," Golden Delicious Apple", .25, " Yellow with an occasional pink blush, Golden Delicious is Apple Lite loved by those who prefer a mild, sweet flavor.");
		Product p2 = new Product(3," Granny Smith Apple", .10, " Grannies are known for their distinctive green flesh which sometimes bears a red blush and their very tart flavor.");
		Product p3 = new Product(4," Honey Crisp Apple", .35, " This honey of an apple has a honeyed, mild flavor and a crispness deemed explosive.");
		Product p4 = new Product(5," McIntosh Apple", .10, " Juicy, tangy, tart McIntosh has a tender, white flesh. It is best used for snacking and applesauce.");
		Product p5 = new Product(6," Red Delicious Apple", .15, " This sweet, crispy, juicy apple varies in color from striped red to solid midnight red.");
		Product p6 = new Product(7," Cripps Pink / Pink Lady Apple", .35, " Developed in Western Australia, Cripps Pink is a cross of Golden Delicious and Lady Williams.");
		Product p7 = new Product(8," Empire Apple", .35, " This crisp, juicy apple has a delightful sweet-tart flavor and creamy white flesh, making it a good all-purpose apple.");
		
		ps.addProduct(p0);
		ps.addProduct(p1);
		ps.addProduct(p2);
		ps.addProduct(p3);
		ps.addProduct(p4);
		ps.addProduct(p5);
		ps.addProduct(p6);
		ps.addProduct(p7);
		
	}

	public static void main(String[] args) {
		SpringApplication.run(TechBeeTrainingApplication.class, args);	
		createEntities();		
	}

}
