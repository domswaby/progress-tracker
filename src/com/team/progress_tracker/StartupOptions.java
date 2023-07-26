package com.team.progress_tracker;

import com.team.progress_tracker.user.User;

public class StartupOptions {
	
	public static User currentUser = null;
	
	public static String handleSignup() {
		
		String firstName = "";
		String lastName = "";
		String username = "";
		String password = "";
		int id = -1;
		
		System.out.println("\nPlease enter your first name: ");
		firstName = Reader.read();
		System.out.println("Please enter your last name: ");
		lastName = Reader.read();
		System.out.println("Please select a username: ");
		username = Reader.read();
		
		//search database for username and if it already exists reprompt for username
		//while(userDaoClass.search(username) != null) {
		//	   System.out.println("This username is taken. Please select a new username.");
		// }
		System.out.println("Please select a password: ");
		password = Reader.read();
		
		//logic for creating a user with the fields, then sets the user
		currentUser = new User(id, firstName, lastName, username, password, false);
		//logic for adding the new to the database
		
		return username;
		
	}
	
	public static String handleLogin() {
		
		String username = "";
		String givenPassword = "";
		String actualPassword = "1";
		boolean success = false;
		User user;
		
		System.out.print("Username: ");
		username = Reader.read();
		
		//search database based on username and password
		//user = userDAO.getUser(username);
		//actualPassword = user.getPassword();
		
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
		//currentUser = user;
		return username;
	}
}
