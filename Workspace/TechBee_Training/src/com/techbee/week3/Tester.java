package com.techbee.week3;

import java.util.Scanner;

public class Tester {	
	
public static void main(String...args) {
	
	{		
		System.out.println("Please make a selection then press Enter.");
		System.out.println("1. Show Sub-Total Balance");
		System.out.println("2. Add Product");
		System.out.println("3. Delete Product");		
		System.out.println("4. Exit");		
	}
	
	ShoppingCart sc = new ShoppingCart(); 
	Product p = new Product();
	Scanner s = new Scanner(System.in);
	byte choice = 0;
	
	choice = s.nextByte(); 
	
	 switch(choice) {
	 case 1:
		 sc.viewAll();
		 break;
	 case 2:
		 sc.add();
		 break;
	 case 3:
		 sc.delete();
		 break;	
	 case 4:
		 System.exit(0); // suppose to exit program
		 break;
		 default:
			 System.out.println("Invalid Choice...");
	 }
	 
	
}
}
