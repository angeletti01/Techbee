package com.techbee.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Occurrences {

	public void occurred() {

		Integer[] intArray = {10, 10, 5, 12, 3, 5};
		List<Integer> arrayInput = new ArrayList<>();	
		Map<Integer, Long> occurMap2 = new HashMap<>();

		for (Integer e : intArray) {			
			arrayInput.add(e);
			occurMap2 = arrayInput.stream().collect(Collectors.toMap(Function.identity(), v -> 1L, Long::sum));
		}

		System.out.println("Array Input: " + arrayInput);
		String convertArray2 = occurMap2.toString().replace("=", ":");		
		System.out.println("Output: " + convertArray2);
	} 
}
