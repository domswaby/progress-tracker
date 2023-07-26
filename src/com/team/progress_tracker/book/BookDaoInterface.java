package com.team.progress_tracker.book;

import java.sql.SQLException;
import java.util.List;

public interface BookDaoInterface {
	// needed for later so we make sure that the connection manager gets called
		public void establishConnection() throws ClassNotFoundException, SQLException;
			
		// as well, this method will help with closing the connection
		public void closeConnection() throws SQLException ;
		
		// Updates values for a given book, assume that the book object contains the id for the book to change.
		// Any values that aren't the id could have been changed, so update them all. As well, as long as the chef
		// exists (id is found in the table), you should be returning a true
		public boolean update(Book book) throws ClassNotFoundException, SQLException;
		
		// Create a new book in the table. Remember, there will be auto increment on the table, so no need
		// to give an id
		public Book add(Book book) throws ClassNotFoundException, SQLException;
		
		// Return all books in the table
		public List<Book> getAll() throws SQLException, ClassNotFoundException;

}
