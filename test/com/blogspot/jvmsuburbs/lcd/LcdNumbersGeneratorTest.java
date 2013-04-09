package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class LcdNumbersGeneratorTest {

	private static final Map<String, String> testCases = new HashMap<String, String>();
	
	@BeforeClass
	public static void setUp(){
		testCases.put("1", LcdNumberExpectedRepresentation.one);
		testCases.put("2", LcdNumberExpectedRepresentation.two);
		testCases.put("8", LcdNumberExpectedRepresentation.eight);
	}
	
	@Test
	public void shouldReturnRepresentationForSimpleNumbers() {
		
		for(Entry<String, String> testEntry : testCases.entrySet()){
			
			String numberRepresentation = LcdNumberGenerator
					.generateRepresentationFor(testEntry.getKey());
			assertEquals(testEntry.getValue(), numberRepresentation);
		}
	}
	
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenInputIsNotANumber(){
		
		// Given
		String input = "Some input";
		
		try {
			// When
			LcdNumberGenerator.generateRepresentationFor(input);
			
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
			LcdNumberGenerator.generateRepresentationFor(input);
			
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
		String numberRepresentation = LcdNumberGenerator.generateRepresentationFor(inputNumber);
		
		// Then
		String correctRepresentation = "   " + " _ " + " _ \n" +
									   "  |" + " _|" + "|_|\n" +
									   "  |" + "|_ " + "|_|\n";
		Assert.assertEquals(correctRepresentation, numberRepresentation);
	}
}
