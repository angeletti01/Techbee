package com.techbee.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TraverseString {

	public void stringTraverser() {
		
		Scanner s = new Scanner(System.in);		
		String sentence = null;
		
		System.out.println("Please type a sentence then press Enter");
		sentence = s.nextLine();			
		
		char[] charArray = sentence.toCharArray();
		List<Character> charArrayList = new ArrayList<>();
		
		for(Character e:charArray) {
			charArrayList.add(e);		
		}		
		
		String result = charArrayList.stream().distinct().collect(Collectors.toList())
				.toString()
				.replace(",", "")
				.replace("[", "")
				.replace("]", "")
				.replace(" ", "");	
			
		System.out.println(result);
		s.close();		
	}	
}
