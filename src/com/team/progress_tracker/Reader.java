package com.team.progress_tracker;

import java.util.Scanner;

	public class Reader {
		public static Scanner reader;
		
		public static String read() {
			String input;
			input = reader.next();
			return input;
		}
		
		public static void startup() {
			
			reader = new Scanner(System.in);
		}
		
		public static void shutdown() {
			reader.close();
		}
}
