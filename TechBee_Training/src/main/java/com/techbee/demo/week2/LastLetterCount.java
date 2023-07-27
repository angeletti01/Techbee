package com.techbee.demo.week2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LastLetterCount {

	public void lastLetter() {

		Scanner s = new Scanner(System.in);
		String sentence = null;
		String switchS = null;
		String switchY = null;
		String[] stringArray = null;
		int sCounter = 0;
		int yCounter = 0;
		int sIndex = 0;
		int yIndex = 0;
		boolean isS = false;
		boolean isY = false;

		try {
			System.out.println("Please enter a sentence then press Enter");
			sentence = s.nextLine();
			stringArray = sentence.split(" ");

		} catch (InputMismatchException i) {
			i.getStackTrace();
		}

		for (int i = 0; i < stringArray.length; i++) {
			for (int j = stringArray[i].length() - 1; j == stringArray[i].length() - 1; j--) {

				if (stringArray[i].charAt(j) == 's' && j == stringArray[i].length() - 1) {
					sCounter++;
					if (isS == false) {
						sIndex = i;
						isS = true;
					}
				}

				else if (stringArray[i].charAt(j) == 'y' && j == stringArray[i].length() - 1) {

					yCounter++;
					if (isY == false) {
						yIndex = i;
						isY = true;
					}
				} else if (stringArray[i].charAt(j) == '.' || stringArray[i].charAt(j) == '?'
						|| stringArray[i].charAt(j) == '!' || stringArray[i].charAt(j) == ',') {

					if (stringArray[i].charAt(j - 1) == 's' && isS == false) {
						sIndex = i;
						isS = true;
						sCounter++;
					}

					else if (stringArray[i].charAt(j - 1) == 'y' && isY == false) {

						yIndex = i;
						isY = true;
						yCounter++;
					} else if (stringArray[i].charAt(j - 1) == 's' && isS == true) {
						sCounter++;
					} else if (stringArray[i].charAt(j - 1) == 'y' && isS == true) {
						yCounter++;
					}
				}
			}

		} // end nested for

		switchS = stringArray[yIndex];
		switchY = stringArray[sIndex];

		stringArray[sIndex] = switchS;
		stringArray[yIndex] = switchY;

		System.out.println("The number of words ending in the letter s are: " + sCounter);
		System.out.println("The number of words ending in the letter y are: " + yCounter);

		String newString = String.join(",", stringArray).replace(",", " ");

		System.out.println(newString);
		s.close();
	} 

} 
