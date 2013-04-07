package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcdNumbersGeneratorTest {

	@Test
	public void shouldReturnRepresentationOf1() {
		
		// Given
		
		// When
		String number = LcdNumberGenerator.generateRepresentationFor("1");
		
		// Then
		String expectedRepresentation = "   \n" + "  |'n" + "  |"; 
		assertEquals(expectedRepresentation, number);
	}

	@Test
	public void shouldReturnRepresentationOf2() {
		
		// Given
		
		// When
		String number = LcdNumberGenerator.generateRepresentationFor("2");
		
		// Then
		String expectedRepresentation = " _ \n" + " _|\n" + "|_ "; 
		assertEquals(expectedRepresentation, number);
	}
	
	@Test
	public void shouldReturnRepresentationOf8() {
		
		// Given
		
		// When
		String number = LcdNumberGenerator.generateRepresentationFor("8");
		
		// Then
		String expectedRepresentation = " _ \n" + "|_|\n" + "|_|"; 
		assertEquals(expectedRepresentation, number);
	}
}
