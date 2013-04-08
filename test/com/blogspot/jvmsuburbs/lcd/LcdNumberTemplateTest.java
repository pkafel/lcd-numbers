package com.blogspot.jvmsuburbs.lcd;

import org.junit.Assert;
import org.junit.Test;

public class LcdNumberTemplateTest {

	@Test
	public void shouldBuildCorrectTemplateWithSize1(){
		// Given
		int size = 1;
		
		// When
		LcdNumberTemplate template = new LcdNumberTemplate.Builder(size).build();
		
		// Then
		Assert.assertEquals(LcdNumberExpectedRepresentation.eight, template.toString());
	}
	
	@Test
	public void shouldBuildAnotherCorrectTemplateWithSize1(){
		// Given
		int size = 1;
		
		// When
		LcdNumberTemplate template = new LcdNumberTemplate.Builder(size)
				.withoutMiddleLeftSide().withoutMiddleCenterSide()
				.withoutDownLeftSide().withoutDownCenterSide().build();
		
		// Then
		Assert.assertEquals(LcdNumberExpectedRepresentation.seven, template.toString());
	}
}
