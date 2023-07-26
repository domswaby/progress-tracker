package com.team.progress_tracker;

public class StartupOptions {
	
	//User currentUser = null;
	
	public static String handleSignup() {
		
		String firstName = "";
		String lastName = "";
		String username = "";
		String password = "";
		
		System.out.println("\nPlease enter your first name: ");
		firstName = Reader.read();
		System.out.println("Please enter your last name: ");
		lastName = Reader.read();
		System.out.println("Please select a username: ");
		username = Reader.read();
		System.out.println("Please select a password: ");
		password = Reader.read();
		
		//logic for creating a user with the fields, then sets the user
		return username;
		
	}
	
	public static String handleLogin() {
		
		String username = "";
		String givenPassword = "";
		String actualPassword = "1";
		boolean success = false;
		
		System.out.print("Username: ");
		username = Reader.read();
		
		do {
			System.out.print("\nPassword: ");
			givenPassword = Reader.read();
			success = true;
			
			if(!givenPassword.equals(actualPassword)) {
				success = false;
				System.out.println("Password was incorrect. Access denied.");
			}
		} while (!success);
		
		//set the user to the current user
		//search database based on username and password		
		
		return username;
	}
}
