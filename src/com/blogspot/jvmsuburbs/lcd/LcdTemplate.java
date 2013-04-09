package com.blogspot.jvmsuburbs.lcd;

public class LcdTemplate {

	private final String[][] representation;
	
	private final int size;
	
	private LcdTemplate(String[][] representation, int size){
		
		this.representation = representation;
		this.size = size;
	}
	
	public LcdTemplate concatenateWithTemplate(LcdTemplate template){
		
		if(this.size != template.getSize()){
			throw new IllegalArgumentException("Two templates must be of the same size !");
		}
		
		return concatenateTemplate(template);
	}
	
	private LcdTemplate concatenateTemplate(LcdTemplate template){

		String[][] newRepresentation = new String[this.representation.length][];
		for (int i = 0; i < this.representation.length; i++) {
			
			newRepresentation[i] = Utils.concatenateArrays(representation[i],
					template.representation[i]);
		}
		
		return new LcdTemplate(newRepresentation, this.getSize());
	}
	
	public int getSize(){
		return size;
	}
	
	@Override
	public String toString(){
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
		
		public Builder(){
			this(1);
		}
		
		public Builder(int size){
			
			this.template = getTemplate(); 
			this.size = size;
		}
		
		private String[][] getTemplate() {

			return new String[][] { { " ", "_", " " }, { "|", "_", "|" },
					{ "|", "_", "|" } };
		}
		
		public int getSize(){
			return size;
		}
		
		public Builder withoutTopCenterSide(){
			template[0][1] = empty;
			return this;
		}
		
		public Builder withoutMiddleLeftSide(){
			template[1][0] = empty;
			return this;
		}
		
		public Builder withoutMiddleCenterSide(){
			template[1][1] = empty;
			return this;
		}
		
		public Builder withoutMiddleRightSide(){
			template[1][2] = empty;
			return this;
		}
		
		public Builder withoutDownLeftSide(){
			template[2][0] = empty;
			return this;
		}
		
		public Builder withoutDownCenterSide(){
			template[2][1] = empty;
			return this;
		}
		
		public Builder withoutDownRightSide(){
			template[2][2] = empty;
			return this;
		}
		
		public LcdTemplate build() {
			LcdTemplate result = new LcdTemplate(template, size);
			this.template = getTemplate();
			return result;
		}
	}
}
