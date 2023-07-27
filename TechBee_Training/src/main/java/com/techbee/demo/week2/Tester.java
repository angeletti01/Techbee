package com.techbee.demo.week2;

import java.util.Scanner;

public class Tester {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);		
		Vowels v = new Vowels();
		Palindrome p = new Palindrome();
		Words w = new Words();
		Consonants c = new Consonants();
		LastLetterCount llc = new LastLetterCount();
		RotateString rs = new RotateString();
		Occurrences o = new Occurrences();
		TraverseString ts = new TraverseString();
		
		byte choice = 0;				
		
		{
			System.out.println("Please select an option from 1 to 8 ");
			System.out.println(" 1 : Vowel class");
			System.out.println(" 2 : Palindrome class");
			System.out.println(" 3: Words class");
			System.out.println(" 4: Consonants class");
			System.out.println(" 5: LastLetterCount class");
			System.out.println(" 6: RotateString class");
			System.out.println(" 7: Occurrences class");
			System.out.println(" 8: TraverseString class");
		}
		
		choice = s.nextByte();
		
		switch(choice) {
		case 1:
			v.countVowels();
			break;
		case 2:
			p.palindromChecker();
			break;
		case 3:
			w.wordCount();
			break;
		case 4: 
			c.consonantCount();
			break;
		case 5:
			llc.lastLetter();
			break;
		case 6:
			rs.stringRotator();
			break;
		case 7:
			o.occurred();
			break;
		case 8:
			ts.stringTraverser();
			break;
			
			default:
				System.out.println("Invalid Selection");
		}		
		s.close();
	}	
}
