package com.blogspot.jvmsuburbs.lcd;

public enum LcdDigit {

	ONE {
		@Override
		public LcdTemplate getRepresentation() {
			return new LcdTemplate.Builder().withoutTopCenterSide()
					.withoutMiddleLeftSide().withoutMiddleCenterSide()
					.withoutDownLeftSide().withoutDownCenterSide().build();
		}
	},
	TWO {
		@Override
		public LcdTemplate getRepresentation() {
			return new LcdTemplate.Builder().withoutMiddleLeftSide()
					.withoutDownRightSide().build();
		}
	},
	EIGHT {
		@Override
		public LcdTemplate getRepresentation() {
			return new LcdTemplate.Builder().build();
		}
	};

	public abstract LcdTemplate getRepresentation();
}
