package com.team.progress_tracker;

import java.util.Scanner;

public class Menu {
	
	public static Scanner reader;
	
	public static int startupMenu(Scanner reader) {
			
			int result = -1;
			boolean valid;
			
			System.out.println("Hello! Welcome to the Backwatcher Virtual Library!");
			System.out.println("Please use one of the provided number options to indicate your choice.");
			System.out.println("\n1. Sign up");
			System.out.println("2. Log in");
			System.out.println("3. Exit Library");
			
			do {
				valid = true;
				try {
					result = Integer.valueOf(Reader.read());
				} catch (NumberFormatException e) {
					valid = false;
				} 
				
				if(result < 1 || result > 3) {
					System.out.println("Please enter one of the provided number options!");
					valid = false;
				}
				
			} while (!valid);
			return result;
					
	}
	
	public static String startupResult(int choice) {
		String username = "";
		
		switch (choice) {
		
		case 1:
			//redirect to sign up screen
			break;
		case 2:
			//redirect to log in screen
			break;
		default:
			System.out.println("Have a great day!");
			Reader.shutdown();
			System.exit(0);
		}
		
		return username;
		
	}
	
	public static int userMenu(String username) {
		int result = -1;
		boolean valid;
		System.out.println("Welcome, " + username + "!");
		System.out.println("What would you like to do today? You must use one of the provided number options to indicate your choice.");
		System.out.println("1. View status");
		System.out.println("2. View global status by book");
		System.out.println("3. Search book database");
		System.out.println("4. View global book rating");
		System.out.println("5: Log out");
		
		do {
			valid = true;
			try {
				result = Integer.valueOf(Reader.read());
			} catch (NumberFormatException e) {
				valid = false;
			} 
			
			if(result < 1 || result > 5) {
				System.out.println("Please enter one of the provided number options!");
				valid = false;
			}
			
		} while (!valid);
		return result;
	}	
		
	public static void userMenuResult(int choice) {
			
			//System.out.print("You have selected ");
			switch (choice) {
			
			case 1:
				//redirect to user book list screen
				break;
			case 2:
				//redirect to book status screen
				break;
			case 3:
				//redirect to book search screen
				break;
			case 4:
				//redirect to rating screen
				break;
			default:
				System.out.println("5: Log out!");
				System.out.println("Have a great day!\n");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"); //temporary "page clear"
				break;
			}
			
	}
	
}
