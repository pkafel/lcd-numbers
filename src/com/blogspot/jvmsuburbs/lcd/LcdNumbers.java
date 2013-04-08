package com.blogspot.jvmsuburbs.lcd;

public enum LcdNumbers {

	ONE {
		@Override
		public String getRepresentation() {
			return new LcdNumberTemplate.Builder().withoutTopCenterSide()
					.withoutMiddleLeftSide().withoutMiddleCenterSide()
					.withoutDownLeftSide().withoutDownCenterSide().build()
					.toString();
		}
	},
	TWO {
		@Override
		public String getRepresentation() {
			return new LcdNumberTemplate.Builder().withoutMiddleLeftSide()
					.withoutDownRightSide().build().toString();
		}
	},
	EIGHT {
		@Override
		public String getRepresentation() {
			return new LcdNumberTemplate.Builder().build().toString();
		}
	};

	public abstract String getRepresentation();
}
