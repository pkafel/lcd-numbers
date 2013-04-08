package com.blogspot.jvmsuburbs.lcd;

import org.junit.Assert;
import org.junit.Test;

public class LcdNumberTemplateTest {

	@Test
	public void shouldBuildCorrectTemplateWithSize1(){
		// Given
		
		// When
		LcdNumberTemplate template = new LcdNumberTemplate.Builder().build();
		
		// Then
		Assert.assertEquals(LcdNumberExpectedRepresentation.eight, template.toString());
	}
	
	@Test
	public void shouldBuildAnotherCorrectTemplateWithSize1(){
		// Given
		
		// When
		LcdNumberTemplate template = new LcdNumberTemplate.Builder()
				.withoutMiddleLeftSide().withoutMiddleCenterSide()
				.withoutDownLeftSide().withoutDownCenterSide().build();
		
		// Then
		Assert.assertEquals(LcdNumberExpectedRepresentation.seven, template.toString());
	}
	
	@Test
	public void shouldAddTwoTemplates(){
		// Given
		LcdNumberTemplate.Builder builder = new LcdNumberTemplate.Builder();
		LcdNumberTemplate t1 = builder.withoutTopCenterSide()
				.withoutTopCenterSide().withoutMiddleLeftSide()
				.withoutMiddleCenterSide().withoutDownLeftSide()
				.withoutDownCenterSide().build();
		LcdNumberTemplate t2 = builder.withoutMiddleLeftSide()
				.withoutDownRightSide().build();
		LcdNumberTemplate t3 = builder.build();

		// When
		LcdNumberTemplate template = t1.concatenateNumber(t2).concatenateNumber(t3);
		
		// Then
		String correctRepresentation = "   " + " _ " + " _ \n" +
				   					   "  |" + " _|" + "|_|\n" +
				   					   "  |" + "|_ " + "|_|\n";
		Assert.assertEquals(correctRepresentation, template.toString());
	}
}
