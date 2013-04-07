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
		assertEquals(LcdNumberExpectedRepresentation.one, number);
	}

	@Test
	public void shouldReturnRepresentationOf2() {
		
		// Given
		
		// When
		String number = LcdNumberGenerator.generateRepresentationFor("2");
		
		// Then 
		assertEquals(LcdNumberExpectedRepresentation.two, number);
	}
	
	@Test
	public void shouldReturnRepresentationOf8() {
		
		// Given
		
		// When
		String number = LcdNumberGenerator.generateRepresentationFor("8");
		
		// Then 
		assertEquals(LcdNumberExpectedRepresentation.eight, number);
	}
}
