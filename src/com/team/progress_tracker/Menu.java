package com.team.progress_tracker;

import java.util.Scanner;

public class Menu {
	
	public static Scanner reader;
	
	/*
	 * Handles the display of both signed in and not signed in menus, as well as their top level logic.
	 */
	
	/*
	 * Accepts user input and checks for invalid inputs. Signing up was not part of MVP, but included anyway.
	 */
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
					System.out.println("Please enter one of the provided number options.");
					valid = false;
				}
				
			} while (!valid);
			return result;
					
	}
	/*
	 * Handles top level logic of signing up, logging in, or shutting down.
	 */
	
	public static String startupResult(int choice) {
		String username = "";
		
		switch (choice) {
		
		case 1:
			username = StartupOptions.handleSignup();
			break;
		case 2:
			username = StartupOptions.handleLogin();
			break;
		default:
			System.out.println("Have a great day!");
			Reader.shutdown();
			System.exit(0);
		}
		
		System.out.println("Welcome, " + username + "!");
		return username;
		
	}
	
	/*
	 * handles logic of a user once logged in, checks for invalid inputs.
	 */
	
	public static int userMenu(String username) {
		int result = -1;
		boolean valid;
		System.out.println("What would you like to do today? You must use one of the provided number options to indicate your choice.");
		System.out.println("1. View your status");
		System.out.println("2. Edit book status");
		System.out.println("3. Add new book tracker");
		System.out.println("4: Log out"); //edit to 5 when we add more
		
		do {
			valid = true;
			try {
				result = Integer.valueOf(Reader.read());
			} catch (NumberFormatException e) {
				valid = false;
			} 
			
			if(result < 1 || result > 4) { //edit to 5 when we add more
				System.out.println("Please enter one of the provided number options!");
				valid = false;
			}
			
		} while (!valid);
		return result;
	}	
	
	/*
	 * handles top level logic of user choices.
	 */
		
	public static void userMenuResult(int choice) {
			
			switch (choice) {
			
			case 1:
				LibraryOptions.userList();
				System.out.println("\n");
				break;
			case 2:
				LibraryOptions.editTracker();
				break;
			case 3:
				LibraryOptions.addTracker();
				break;
			default:
				System.out.println("4: Log out");
				System.out.println("Please come again!\n");
				try {
					Thread.sleep(500); //wait a little
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n"); //temporary "page clear"
				break;
			}
			
	}
	
}
