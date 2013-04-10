package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LcdNumbersGeneratorTest {

	private static final Map<String, String> testCases = new LinkedHashMap<String, String>();
	
	@BeforeClass
	public static void setUp(){
		
		testCases.put("0", LcdNumberExpectedRepresentation.WithSize1.zero);
		testCases.put("1", LcdNumberExpectedRepresentation.WithSize1.one);
		testCases.put("2", LcdNumberExpectedRepresentation.WithSize1.two);
		testCases.put("3", LcdNumberExpectedRepresentation.WithSize1.three);
		testCases.put("4", LcdNumberExpectedRepresentation.WithSize1.four);
		testCases.put("5", LcdNumberExpectedRepresentation.WithSize1.five);
		testCases.put("6", LcdNumberExpectedRepresentation.WithSize1.six);
		testCases.put("7", LcdNumberExpectedRepresentation.WithSize1.seven);
		testCases.put("8", LcdNumberExpectedRepresentation.WithSize1.eight);
		testCases.put("9", LcdNumberExpectedRepresentation.WithSize1.nine);
	}
	
	@Test
	public void shouldReturnRepresentationForSimpleNumbers() {
		
		for(Entry<String, String> testEntry : testCases.entrySet()){
			
			String numberRepresentation = LcdNumberGenerator
					.getRepresentationFor(testEntry.getKey());
			assertEquals(testEntry.getValue(), numberRepresentation);
		}
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenInputIsNotANumber(){
		
		// Given
		String input = "Some input";
		
		try {
			// When
			LcdNumberGenerator.getRepresentationFor(input);
			
			// Then
			Assert.fail();
		} catch (Exception exception) {
			
			Assert.assertTrue(exception instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenInputIsEmpty(){
		
		// Given
		String input = "";
		
		try {
			// When
			LcdNumberGenerator.getRepresentationFor(input);
			
			// Then
			Assert.fail();
		} catch (Exception exception) {
			
			Assert.assertTrue(exception instanceof IllegalArgumentException);
		}
	}
	
	@Test
	public void shouldReturnRepresentationForComplexNumbers() {
		
		// Given
		String inputNumber = "128";
		
		// When
		String numberRepresentation = LcdNumberGenerator.getRepresentationFor(inputNumber);
		
		// Then
		String correctRepresentation = "   " + " _ " + " _ \n" +
									   "  |" + " _|" + "|_|\n" +
									   "  |" + "|_ " + "|_|\n";
		Assert.assertEquals(correctRepresentation, numberRepresentation);
	}
}
