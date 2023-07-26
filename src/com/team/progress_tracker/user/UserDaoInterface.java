package com.team.progress_tracker.user;

import java.sql.SQLException;
import java.util.Optional;

public interface UserDaoInterface {
		
		// needed for later so we make sure that the connection manager gets called
		public void establishConnection() throws ClassNotFoundException, SQLException;
		
		// as well, this method will help with closing the connection
		public void closeConnection() throws SQLException ;
		
		// Find a user by their id and returns an Optional of user (check notes/code from Java Streams to review
		// Optional and how to use them)
		public Optional<User> login(String username) throws ClassNotFoundException, SQLException;
		
		// Create a new user in the table. Remember, there will be auto increment on the table, so no need
		// to give an id
		public User signup(User username, User first_name, User last_name, User password) throws ClassNotFoundException, SQLException;

		// Return a list of user who all work in the same restaurant, if no chefs are in the restaurant given
		// it is okay to return an empty list
		//public List<User> findByUsername(String username);
		
		// Return the average rating of all chefs in the same restaurant. If no chefs are in the restaurant given,
		// it is okay to return a 0
		//public double avgRatingByRestaurant(String restaurant);
		
}
