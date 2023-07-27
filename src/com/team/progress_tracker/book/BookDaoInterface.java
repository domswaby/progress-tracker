package com.team.progress_tracker.book;

import java.sql.SQLException;

public interface BookDaoInterface {
	// needed for later so we make sure that the connection manager gets called
		public void establishConnection() throws ClassNotFoundException, SQLException;
			
		// as well, this method will help with closing the connection
		public void closeConnection() throws SQLException ;
		
		// Updates values for a given book, assume that the book object contains the id for the book to change.
		// Any values that aren't the id could have been changed, so update them all. As well, as long as the chef
		// exists (id is found in the table), you should be returning a true
		public boolean update(Book book, double rating, String status) throws ClassNotFoundException, SQLException;
		
		// Create a new book in the table. Remember, there will be auto increment on the table, so no need
		// to give an id
		public void add(Book book, double rating, String status) throws ClassNotFoundException, SQLException;
		
		// Return all books in the table
		public void getAll() throws SQLException, ClassNotFoundException;

}
