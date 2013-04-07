package com.blogspot.jvmsuburbs.lcd;

public enum LcdNumbers {

	ONE {
		@Override
		public String getRepresentation() {
			String[][] template = getTemplate();
			template[0][1] = " ";
			template[1][0] = " ";
			template[1][1] = " ";
			template[2][0] = " ";
			template[2][1] = " ";
			return transformTemplateIntoString(template);
		}
	},
	TWO {
		@Override
		public String getRepresentation() {
			String[][] template = getTemplate();
			template[1][0] = " ";
			template[2][2] = " ";
			return transformTemplateIntoString(template);
		}
	};

	public abstract String getRepresentation();

	private static String transformTemplateIntoString(String[][] template) {

		StringBuilder builder = new StringBuilder();

		for (String[] templateLineElements : template) {

			for (String lineElement : templateLineElements) {

				builder.append(lineElement);
			}

			builder.append("\n");
		}

		return builder.toString();
	}

	private static String[][] getTemplate() {

		return new String[][] { { " ", "_", " " }, { "|", "_", "|" },
				{ "|", "_", "|" } };
	}
}
