package com.team.progress_tracker.user;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UserDaoInterface {
		
		// needed for later so we make sure that the connection manager gets called
		public void establishConnection() throws ClassNotFoundException, SQLException;
		
		// as well, this method will help with closing the connection
		public void closeConnection() throws SQLException ;
		
		
		// Return all users in the table
		public List<User> getAll() throws SQLException, ClassNotFoundException;
		
		// Find a user by their id and returns an Optional of user (check notes/code from Java Streams to review
		// Optional and how to use them)
		public Optional<User> findById(int userID) throws ClassNotFoundException, SQLException;
		
		// Updates values for a given user, assume that the chef object contains the id for the user to change.
		// Any values that aren't the id could have been changed, so update them all. As well, as long as the user
		// exists (id is found in the table), you should be returning a true
		public boolean update(User user) throws ClassNotFoundException, SQLException;
		
		// Removes a user by their id. As long as the id given is in the table, return true that you removed
		// that user
		public boolean delete(int userID) throws ClassNotFoundException, SQLException;
		
		// Create a new user in the table. Remember, there will be auto increment on the table, so no need
		// to give an id
		public User add(User user) throws ClassNotFoundException, SQLException;

		// Return a list of user who all work in the same restaurant, if no chefs are in the restaurant given
		// it is okay to return an empty list
		//public List<User> findByUsername(String username);
		
		// Return the average rating of all chefs in the same restaurant. If no chefs are in the restaurant given,
		// it is okay to return a 0
		//public double avgRatingByRestaurant(String restaurant);
		
}
