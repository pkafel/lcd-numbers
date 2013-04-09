package com.blogspot.jvmsuburbs.lcd;

import org.junit.Assert;
import org.junit.Test;

public class UtilsTest {

	@Test
	public void shouldConcatenateTwoArrays() {
		// Given
		String[] array1 = new String[] {"a", "b", "c"};
		String[] array2 = new String[] {"d", "e"};
		
		// When
		String[] resultArray = Utils.concatenateArrays(array1, array2);
		
		// Then
		Assert.assertEquals(array1.length + array2.length, resultArray.length);
		
		for(int i = 0; i < array1.length; i++){
			
			Assert.assertEquals(array1[i], resultArray[i]);
		}
		
		for(int i = array1.length; i < array1.length + array2.length; i++){
			
			Assert.assertEquals(array2[i], resultArray[i]);
		}
	}

	@Test
	public void shouldConcatenateTwoArraysWhenFirstIsEmpty() {
		// Given
		String[] array1 = new String[] {};
		String[] array2 = new String[] {};
		
		// When
		String[] resultArray = Utils.concatenateArrays(array1, array2);
		
		// Then
		Assert.assertEquals(array2.length, resultArray.length);
		
		for(int i = 0; i < array2.length; i++){
			
			Assert.assertEquals(array2[i], resultArray[i]);
		}
	}
	
	@Test
	public void shouldConcatenateTwoArraysWhenSecondIsEmpty() {
		// Given
		String[] array1 = new String[] {};
		String[] array2 = new String[] {};

		// When
		String[] resultArray = Utils.concatenateArrays(array1, array2);

		// Then
		Assert.assertEquals(array1.length, resultArray.length);

		for (int i = 0; i < array1.length; i++) {

			Assert.assertEquals(array1[i], resultArray[i]);
		}
	}
	
	@Test
	public void shouldConcatenateTwoArraysWhenBothAreEmpty() {
		// Given
		String[] array1 = new String[] {};
		String[] array2 = new String[] {};
		
		// When
		String[] resultArray = Utils.concatenateArrays(array1, array2);
		
		// Then
		Assert.assertEquals(0, resultArray.length);
	}
	
}
