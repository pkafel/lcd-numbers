package com.blogspot.jvmsuburbs.lcd;

import java.util.Arrays;

public class LcdTemplate {

	private final String[][] representation;

	private final int size;

	private LcdTemplate(String[][] representation, int size) {

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

		String[][] newRepresentation = new String[this.representation.length][];
		for (int i = 0; i < this.representation.length; i++) {

			newRepresentation[i] = Utils.concatenateArrays(representation[i],
					template.representation[i]);
		}

		return new LcdTemplate(newRepresentation, this.getSize());
	}

	public int getSize() {

		return size;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		for (String[] representationLineElements : representation) {

			for (String lineElement : representationLineElements) {

				builder.append(lineElement);
			}

			builder.append("\n");
		}

		return builder.toString();
	}

	public static class Builder {

		private final int size;

		private static final String empty = " ";

		private String[][] template;

		public Builder() {
			this(1);
		}

		public Builder(int size) {

			this.template = getTemplate(size);
			this.size = size;
		}

		private String[][] getTemplate(int size) {

			String[][] result = new String[2 * size + 1][];
			result[0] = getTopPart(size);

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < size - 1; j++) {

					result[i * size + j + 1] = getExtensionPart(size);
				}

				result[i * size + size] = getHorizontalPart(size);
			}

			return result;
		}

		private String[] getTopPart(int size) {

			String[] top = new String[size + 2];
			Arrays.fill(top, "_");
			top[0] = empty;
			top[top.length - 1] = empty;

			return top;
		}

		private String[] getExtensionPart(int size) {

			String[] extension = new String[size + 2];
			Arrays.fill(extension, empty);
			extension[0] = "|";
			extension[extension.length - 1] = "|";

			return extension;
		}

		private String[] getHorizontalPart(int size) {

			String[] extension = new String[size + 2];
			Arrays.fill(extension, "_");
			extension[0] = "|";
			extension[extension.length - 1] = "|";

			return extension;
		}

		public int getSize() {

			return size;
		}

		public Builder withoutTopCenterSide() {

			for (int i = 0; i < size; i++) {
				template[0][i + 1] = empty;
			}
			return this;
		}

		public Builder withoutMiddleLeftSide() {

			for (int i = 1; i < size + 1; i++) {
				template[i][0] = empty;
			}
			return this;
		}

		public Builder withoutMiddleCenterSide() {

			for (int i = 0; i < size; i++) {
				template[size][i + 1] = empty;
			}
			return this;
		}

		public Builder withoutMiddleRightSide() {

			for (int i = 1; i < size + 1; i++) {
				template[i][template[i].length - 1] = empty;
			}
			return this;
		}

		public Builder withoutDownLeftSide() {

			for (int i = 1; i < size + 1; i++) {
				template[size + i][0] = empty;
			}
			return this;
		}

		public Builder withoutDownCenterSide() {

			for (int i = 0; i < size; i++) {
				template[2 * size][i + 1] = empty;
			}
			return this;
		}

		public Builder withoutDownRightSide() {

			for (int i = 1; i < size + 1; i++) {
				template[size + i][template[i].length - 1] = empty;
			}
			return this;
		}

		public LcdTemplate build() {

			LcdTemplate result = new LcdTemplate(template, size);
			this.template = getTemplate(size);
			return result;
		}
	}
}
