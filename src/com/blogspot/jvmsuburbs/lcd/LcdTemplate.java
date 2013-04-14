package com.blogspot.jvmsuburbs.lcd;

import static com.blogspot.jvmsuburbs.lcd.LcdConsts.*;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LcdTemplate {

	private final List<String> representation;

	private final int size;

	private LcdTemplate(List<String> representation, int size) {

		this.representation = representation;
		this.size = size;
	}

	public LcdTemplate concatenateWithTemplate(LcdTemplate template) {

		if (this.size != template.getSize()) {
			throw new IllegalArgumentException("Two templates must be of the same size !");
		}

		return concatenateTemplate(template);
	}

	private LcdTemplate concatenateTemplate(LcdTemplate template) {

		List<String> newRepresentation = new ArrayList<String>();
		for (int i = 0; i < this.representation.size(); i++) {

			newRepresentation.add(representation.get(i)
					+ template.representation.get(i));
		}

		return new LcdTemplate(newRepresentation, this.getSize());
	}

	public int getSize() {

		return size;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		for (String representationLineElements : representation) {

			builder.append(representationLineElements);
			builder.append("\n");
		}

		return builder.toString();
	}

	public static class Builder {
		
		private enum LcdElement {
			TOP, MIDDLE_LEFT, MIDDLE_CENTER, MIDDLE_RIGHT, BOTTOM_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT
		}

		private final int size;
		
		private final Map<LcdElement, Boolean> something = new EnumMap<LcdElement, Boolean>(
				LcdElement.class);

		public Builder() {

			this(1);
		}

		public Builder(int size) {

			this.size = size;
			resetBuildState();
		}
		
		private void resetBuildState(){
			
			for(LcdElement element : LcdElement.values()){

				something.put(element, true);
			}
		}

		public int getSize() {

			return size;
		}

		public Builder withoutTopCenterSide() {

			something.put(LcdElement.TOP, false);
			return this;
		}

		public Builder withoutMiddleLeftSide() {

			something.put(LcdElement.MIDDLE_LEFT, false);
			return this;
		}

		public Builder withoutMiddleCenterSide() {

			something.put(LcdElement.MIDDLE_CENTER, false);
			return this;
		}

		public Builder withoutMiddleRightSide() {

			something.put(LcdElement.MIDDLE_RIGHT, false);
			return this;
		}

		public Builder withoutDownLeftSide() {

			something.put(LcdElement.BOTTOM_LEFT, false);
			return this;
		}

		public Builder withoutDownCenterSide() {

			something.put(LcdElement.BOTTOM_CENTER, false);
			return this;
		}

		public Builder withoutDownRightSide() {

			something.put(LcdElement.BOTTOM_RIGHT, false);
			return this;
		}

		public LcdTemplate build() {

			LcdTemplate result = new LcdTemplate(getRepresentation(), size);
			resetBuildState();
			return result;
		}
		
		private List<String> getRepresentation() {

			List<String> result = new ArrayList<String>();
			
			result.add(getTop());
			for(int i = 0; i < size - 1; i++){
				
				result.add(getVerticalMiddle());
			}
			
			result.add(getHorizontalMiddle());
			
			for(int i = 0; i < size - 1; i++){
				
				result.add(getVerticalBottom());
			}
			result.add(getHorizontalBottom());
			
			return result;
		}

		private String getTop() {

			char centerFiller = something.get(LcdElement.TOP) ? horizontal : empty;

			return buildRow(empty, centerFiller, empty);
		}

		private String getHorizontalMiddle() {

			char leftFiller = something.get(LcdElement.MIDDLE_LEFT) ? vertical : empty;
			char rightFiller = something.get(LcdElement.MIDDLE_RIGHT) ? vertical : empty;
			char centerFiller = something.get(LcdElement.MIDDLE_CENTER) ? horizontal : empty;
			
			return buildRow(leftFiller, centerFiller, rightFiller);
		}
		
		private String getHorizontalBottom() {

			char leftFiller = something.get(LcdElement.BOTTOM_LEFT) ? vertical : empty;
			char rightFiller = something.get(LcdElement.BOTTOM_RIGHT) ? vertical : empty;
			char centerFiller = something.get(LcdElement.BOTTOM_CENTER) ? horizontal : empty;

			return buildRow(leftFiller, centerFiller, rightFiller);
		}

		private String getVerticalMiddle() {

			char leftFiller = something.get(LcdElement.MIDDLE_LEFT) ? vertical : empty;
			char rightFiller = something.get(LcdElement.MIDDLE_RIGHT) ? vertical : empty;

			return buildRow(leftFiller, empty, rightFiller);
		}
		
		private String getVerticalBottom() {

			char leftFiller = something.get(LcdElement.BOTTOM_LEFT) ? vertical : empty;
			char rightFiller = something.get(LcdElement.BOTTOM_RIGHT) ? vertical : empty;

			return buildRow(leftFiller, empty, rightFiller);
		}
		
		private String buildRow(char left, char centerFiller, char right){
			
			StringBuilder builder = new StringBuilder();
			
			builder.append(left);
			for (int i = 0; i < size; i++) {
				builder.append(centerFiller);
			}
			builder.append(right);
			
			return builder.toString();
		}
	}
}
