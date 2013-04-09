package com.blogspot.jvmsuburbs.lcd;

public enum LcdDigit {

	ONE {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {
			
			return new LcdTemplate.Builder(size).withoutTopCenterSide()
					.withoutMiddleLeftSide().withoutMiddleCenterSide()
					.withoutDownLeftSide().withoutDownCenterSide().build();
		}
	},
	TWO {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {
			
			return new LcdTemplate.Builder(size).withoutMiddleLeftSide()
					.withoutDownRightSide().build();
		}
	},
	EIGHT {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {
			
			return new LcdTemplate.Builder(size).build();
		}
	};

	public abstract LcdTemplate getRepresentationForSize(int size);
}
