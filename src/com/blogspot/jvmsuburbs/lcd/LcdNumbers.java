package com.blogspot.jvmsuburbs.lcd;

public enum LcdNumbers {

	ONE {
		@Override
		public LcdNumberTemplate getRepresentation() {
			return new LcdNumberTemplate.Builder().withoutTopCenterSide()
					.withoutMiddleLeftSide().withoutMiddleCenterSide()
					.withoutDownLeftSide().withoutDownCenterSide().build();
		}
	},
	TWO {
		@Override
		public LcdNumberTemplate getRepresentation() {
			return new LcdNumberTemplate.Builder().withoutMiddleLeftSide()
					.withoutDownRightSide().build();
		}
	},
	EIGHT {
		@Override
		public LcdNumberTemplate getRepresentation() {
			return new LcdNumberTemplate.Builder().build();
		}
	};

	public abstract LcdNumberTemplate getRepresentation();
}
