package com.blogspot.jvmsuburbs.lcd;

import static org.junit.Assert.*;

import org.junit.Test;

public class LcdNumbersGeneratorTest {

	@Test
	public void test() {
		
		// Given
		
		// When
		String number = LcdNumberGenerator.generateRepresentationFor("1");
		
		// Then
		String expectedRepresentation = "   \n" + "  |'n" + "  |"; 
		assertEquals(expectedRepresentation, number);
	}

}
