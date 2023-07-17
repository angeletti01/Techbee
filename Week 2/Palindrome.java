package com.techbee.week2;

import java.util.Scanner;

public class Palindrome {
	
	public void palindromChecker() {
		Scanner s = new Scanner(System.in);
		String word = null;
		Integer count = 0;		
		
		System.out.println("Please enter a word, then press Enter");
		word = s.nextLine().toLowerCase();
		System.out.println("Your word: " + word);
		
		char[] reverseArray = new char[word.length()];
		
		for(int i = word.length()-1; i >= 0; i--) {
		reverseArray[count] = word.charAt(i);			
		count++;
		}

		String result = String.copyValueOf(reverseArray);
		
		if(word.equals(result)) {
			System.out.println(word +" is a Palindrome!");			
		}
		else {
			System.out.println(word+" is not a Palindrome...");
		}
		s.close();
	}
	
	
}
