package com.techbee.demo.week2;

import java.util.Scanner;

public class Vowels {
	
	public void countVowels() {
		
		Scanner s = new Scanner(System.in);		
		String sentence = null;
		Integer count = 0;		
		
		System.out.println("Input a sentence then press Enter....");
		
		sentence = s.nextLine();
		System.out.println("Your sentence is: "+sentence);
		String removeSpaces = sentence.replace(" ", "").toLowerCase();
		
		for(int i = 0; i < removeSpaces.length();i++) {
			
			if(removeSpaces.charAt(i) == 'a' || removeSpaces.charAt(i) == 'e' || removeSpaces.charAt(i) == 'i' 
					|| removeSpaces.charAt(i) == 'o' || removeSpaces.charAt(i) == 'u')
			{
				count++; 
			}			
		}	
		System.out.println("The number of vowels in the sentence is: " + count);
		s.close();
	}

	

}
