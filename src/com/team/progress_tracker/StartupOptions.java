package com.team.progress_tracker;

import java.sql.SQLException;
import java.util.Optional;

import com.team.progress_tracker.user.User;
import com.team.progress_tracker.user.UserDaoImp;

public class StartupOptions {
	
	public static User currentUser = null;
	public static UserDaoImp handler;
	
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
		while(!handler.search(username).isEmpty()) {
			   System.out.println("This username is taken. Please select a new username.");
		}
		
		System.out.println("Please select a password: ");
		password = Reader.read();
		
		//logic for creating a user with the fields, then sets the user
		currentUser = new User(id, firstName, lastName, username, password, false);
		try {
			id = handler.signup(currentUser);
			currentUser.setUser_ID(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//logic for adding the new to the database
				
		return username;
		
	}
	
	public static String handleLogin() {
		
		String username = "";
		String givenPassword = "";
		String actualPassword = "";
		boolean success = false;
		Optional<User> user = null;
	
		//search database based on username and password
		
		do {
			
			System.out.print("Username: ");
			username = Reader.read();
			try {
				user = handler.login(username);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(user.isEmpty()) {
				System.out.println("Username invalid. Please try again.\n");
			}
			
		} while (user.isEmpty());
		actualPassword = user.get().getPassword();
		
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
		currentUser = user.get();
		return username;
	}
}
