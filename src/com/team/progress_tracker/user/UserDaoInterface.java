package com.team.progress_tracker.user;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDaoInterface {
		
		// needed for later so we make sure that the connection manager gets called
		public void establishConnection() throws ClassNotFoundException, SQLException;
		
		// as well, this method will help with closing the connection
		public void closeConnection() throws SQLException;
		
		// Find a user by their id and returns an Optional of user (check notes/code from Java Streams to review
		// Optional and how to use them)
		public Optional<User> login(String username) throws ClassNotFoundException, SQLException;
		
		// Create a new user in the table. Remember, there will be auto increment on the table, so no need
		// to give an id
		public int signup(User user) throws ClassNotFoundException, SQLException;
		
		//searches a user by their username. if no user is found, it can return empty
		public Optional<User> search(String username);
		
		// Return a list of books checked out by a user
		// it is okay to return an empty list
		//public List<User> findByUsername(String username);
		
		// Return the average rating of a book. If no one has rated a book,
		// it is okay to return a 0
		//public double avgRating(String book);
		
}
