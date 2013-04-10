package com.blogspot.jvmsuburbs.lcd;

public enum LcdDigit {

	ZERO {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutMiddleCenterSide()
					.build();
		}
	},

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
	THREE {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutMiddleLeftSide()
					.withoutDownLeftSide().build();
		}
	},
	FOUR {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutTopCenterSide()
					.withoutDownLeftSide().withoutDownCenterSide().build();
		}
	},
	FIVE {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutMiddleRightSide()
					.withoutDownLeftSide().build();
		}

	},
	SIX {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutMiddleRightSide()
					.build();
		}
	},
	SEVEN {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutMiddleLeftSide()
					.withoutMiddleCenterSide().withoutDownLeftSide()
					.withoutDownCenterSide().build();
		}
	},
	EIGHT {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).build();
		}
	},
	NINE {
		@Override
		public LcdTemplate getRepresentationForSize(int size) {

			return new LcdTemplate.Builder(size).withoutDownLeftSide().build();
		}
	};

	public abstract LcdTemplate getRepresentationForSize(int size);
	
	public LcdTemplate getRepresentation() {
		
		return getRepresentationForSize(1);
	}
}
