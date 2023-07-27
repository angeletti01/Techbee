package com.techbee.demo.week2;


import java.util.Scanner;

public class RotateString {
	public void stringRotator() {
		Scanner s = new Scanner(System.in);
		String word = null; 
		String input = null;
		
		int numberPlacement = 0;
		int characterCount = 0;
		String sub1 = null; 
		String sub2 = null;
		boolean isValid = false;
				
		System.out.println("Please enter a word and press Enter");
		word = s.nextLine().replace(" ", "");
		characterCount = word.length();
		
			do {
				try {
					System.out.println("Please enter a number between 1 and "+(characterCount));
				
					input = s.nextLine();
					numberPlacement = Integer.parseInt(input);
					if(numberPlacement > 0 && numberPlacement <= characterCount) {
						System.out.println("Number chosen is: "+numberPlacement);
						isValid = true;
					}
					else {
						System.out.println("Please enter a number between 0 and "+(characterCount));
						numberPlacement = s.nextInt();
						isValid = false;
					}
					}
					catch(NumberFormatException i) {
						i.printStackTrace();
						System.out.println("Incorrect input, please enter number between 1 and: "+characterCount);
					}
			}
			while(isValid == false);	
		
		sub2 = word.substring(numberPlacement);
		sub1 = word.substring(0, numberPlacement);
		word = sub2.concat(sub1);
		System.out.println(word);
	s.close();
	}
}
