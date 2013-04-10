package com.blogspot.jvmsuburbs.lcd;

public final class LcdNumberExpectedRepresentation {

	private LcdNumberExpectedRepresentation() { }
	
	public final static class WithSize1 {
		
		private WithSize1() {}
		
		public static final String zero =  " _ \n" + "| |\n" + "|_|\n";
		
		public static final String one =   "   \n" + "  |\n" + "  |\n";
		
		public static final String two =   " _ \n" + " _|\n" + "|_ \n";
		
		public static final String three = " _ \n" + " _|\n" + " _|\n";
		
		public static final String four =  "   \n" + "|_|\n" + "  |\n";
		
		public static final String five =  " _ \n" + "|_ \n" + " _|\n";
		
		public static final String six =   " _ \n" + "|_ \n" + "|_|\n";
		
		public static final String seven = " _ \n" + "  |\n" + "  |\n";
		
		public static final String eight = " _ \n" + "|_|\n" + "|_|\n";
		
		public static final String nine =  " _ \n" + "|_|\n" + " _|\n";
	}
	
	public final static class WithSize2 {
		
		private WithSize2() {}
		
		public static final String zero =  " __ \n" + 
										   "|  |\n" + 
										   "|  |\n" +
										   "|  |\n" + 
										   "|__|\n";
		
		public static final String one =   "    \n" + 
				   						   "   |\n" + 
				   						   "   |\n" +
				   						   "   |\n" + 
				   						   "   |\n";
		
		public static final String two =   " __ \n" + 
				   						   "   |\n" + 
				   						   " __|\n" +
				   						   "|   \n" + 
				   						   "|__ \n";
		
		public static final String three = " __ \n" + 
				   						   "   |\n" + 
				   						   " __|\n" +
				   						   "   |\n" + 
				   						   " __|\n";
		
		public static final String four =  "    \n" + 
				   						   "|  |\n" + 
				   						   "|__|\n" +
				   						   "   |\n" + 
				   						   "   |\n";
		
		public static final String five =  " __ \n" + 
				   						   "|   \n" + 
				   						   "|__ \n" +
				   						   "   |\n" + 
				   						   " __|\n";
		
		public static final String six =   " __ \n" + 
				   						   "|   \n" + 
				   						   "|__ \n" +
				   						   "|  |\n" + 
				   						   "|__|\n";
		
		public static final String seven = " __ \n" + 
				   						   "   |\n" + 
				   						   "   |\n" +
				   						   "   |\n" + 
				   						   "   |\n";
		
		public static final String eight = " __ \n" + 
				   						   "|  |\n" + 
				   						   "|__|\n" +
				   						   "|  |\n" + 
				   						   "|__|\n";
		
		public static final String nine =  " __ \n" + 
				   						   "|  |\n" + 
				   						   "|__|\n" +
				   						   "   |\n" + 
				   						   " __|\n";
	}
}
