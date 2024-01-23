package com.muthukumarasamy.busticket.colors;

public class Color {
	
		public static final String RESET = "\u001B[0m";
		public static final String BOLD = "\u001B[1m";
		public final static String BOLD_WHITE = "\u001B[1;37m";

		// Light colors
		public static final String BLACK = "\u001B[90m";
		public static final String RED = "\u001B[91m";
		public static final String GREEN = "\u001B[92m";
		public static final String YELLOW = "\u001B[93m";
		public static final String BLUE = "\u001B[94m";
		public static final String MAGENTA = "\u001B[95m";
		public static final String CYAN = "\u001B[96m";
		public static final String WHITE = "\u001B[97m";
		//BRIGHT COLORS
		public static final String BRIGHT_BLACK = "\u001B[30;1m";
		public static final String BRIGHT_WHITE = "\u001B[97;1m";
		public static final String BRIGHT_RED = "\u001B[91;1m";
		public static final String BRIGHT_GREEN = "\u001B[92;1m";
		public static final String BRIGHT_YELLOW = "\u001B[93;1m";
		public static final String BRIGHT_BLUE = "\u001B[94;1m";
		public static final String BRIGHT_MAGENTA = "\u001B[95;1m";
		public static final String BRIGHT_CYAN = "\u001B[96;1m";
		// Italic and Underline
		public static final String ITALIC = "\u001B[3m";
		public static final String UNDERLINE = "\u001B[4m";
		public static final String ITALIC_UNDERLINE = "\u001B[3;4m";

	public static void main(String[] args) {
	
		System.out.println("BOLD_WHITE - "+BOLD_WHITE+"HELO"+RESET);
		System.out.println("BLACK -"+BLACK+"HELO"+RESET);
		System.out.println("RED - "+RED+"HELO"+RESET);
		System.out.println("YELLOW - "+YELLOW+"HELO"+RESET);
		System.out.println("BLUE - "+BLUE+"HELO"+RESET);
		System.out.println("CYAN - "+CYAN+"HELO"+RESET);
		System.out.println("WHITE "+WHITE+"HELO"+RESET);
		System.out.println("BRIGHT_WHITE - "+BRIGHT_WHITE+"HELO"+RESET);
		System.out.println("BRIGHT_BLACK - "+BRIGHT_BLACK+"HELO"+RESET);
		
		
	}

	
	
	
}
