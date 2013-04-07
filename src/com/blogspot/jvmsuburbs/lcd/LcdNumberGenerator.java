package com.blogspot.jvmsuburbs.lcd;

public class LcdNumberGenerator {

	private static final String one = "   \n" + "  |'n" + "  |";
	private static final String two = " _ \n" + " _|\n" + "|_ "; 
	
	public static String generateRepresentationFor(String numberToRepresent) {

		if (numberToRepresent.equals("1")) {
			
			return one;
			
		} else {
			
			return two;
		}
	}
}
