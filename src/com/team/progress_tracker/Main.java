package com.team.progress_tracker;

import java.util.Scanner;

public class Main {	
	public static Scanner reader;


	public static void main(String[] args) {
		int result = -1;
		String username = "";
		
		Reader.startup(); //starts the reader
		
		result = Menu.startupMenu(reader); // gets the result of the initial login or account creation screen
		username = Menu.startupResult(result); // handles the creation of a new account or the login of an old one
		
		while (true) {
			if (result != 3) { //if the user doesn't want to log out; edit to 4 when we add more
				result = Menu.userMenu(username);
				Menu.userMenuResult(result);
			} else {
				result = Menu.startupMenu(reader); //if the user did log out, the system prompts them to log back in or shut down
				username = Menu.startupResult(result);
			}
		}
	}	

}
