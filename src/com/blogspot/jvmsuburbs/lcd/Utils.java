package com.blogspot.jvmsuburbs.lcd;

public class Utils {
	
	private Utils() { }

	public static String[] concatenateArrays(String[] array1, String[] array2) {

		String[] resultArray = new String[array1.length + array2.length];
		System.arraycopy(array1, 0, resultArray, 0, array1.length);
		System.arraycopy(array2, 0, resultArray, array1.length, array2.length);
		return resultArray;
	}
}
