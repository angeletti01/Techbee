package com.techbee.demo.week2;

import java.util.Scanner;

public class Consonants {

	public void consonantCount() {

		Scanner s = new Scanner(System.in);
		String[] stringArray = null;
		char[] stringToChar = null;
		String sentence = null;
		Integer consonantCount = 0;
		String currentString;

		System.out.println("Please enter a sentence then press Enter");
		sentence = s.nextLine();		
		stringArray = sentence.split(" ");
		String removeSpace = sentence.replace(" ", "");		

		for (int i = 0; i < removeSpace.length(); i++) {

			if (removeSpace.charAt(i) != 'a' && removeSpace.charAt(i) != 'e' && removeSpace.charAt(i) != 'i'
					&& removeSpace.charAt(i) != 'o' && removeSpace.charAt(i) != 'u'&& removeSpace.charAt(i) != '!'
					&& removeSpace.charAt(i) != '.' && removeSpace.charAt(i) != '?') {
				consonantCount++;
			}
		}		
		System.out.println("The number of consonants are: " + consonantCount);

		for (int i = 0; i < stringArray.length; i++) {
			currentString = stringArray[i];
			stringToChar = currentString.toCharArray();

			for (int j = 0; j < stringToChar.length; j++) {
				if (stringToChar[j] != 'a' && stringToChar[j] != 'e' && stringToChar[j] != 'i' && stringToChar[j] != 'o'
						&& stringToChar[j] != 'u'&& stringToChar[j] != ','&& stringToChar[j] != '!'
						&& stringToChar[j] != '.'&& stringToChar[j] != '?') {
					stringToChar[j] = '*';
				}
			}			
			stringArray[i] = String.valueOf(stringToChar);
		}
		String newString = String.join(",", stringArray).replace(",", " ");
		System.out.println(newString);
		s.close();
	}
}
