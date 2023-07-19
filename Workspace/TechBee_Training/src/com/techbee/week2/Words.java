package com.techbee.week2;

import java.util.Scanner;

public class Words {
	
public void wordCount() {
	Scanner s = new Scanner(System.in);
	String[] stringArray = null;
	String input = null;
	
	System.out.println("Please enter a sentence and press Enter!");
	input = s.nextLine();
	stringArray = input.split(" ");
	System.out.println("The amount of words in the sentence is: " +stringArray.length);
	s.close();
	
}
}
