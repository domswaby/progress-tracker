package com.team.progress_tracker.book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import com.team.progress_tracker.ConnectionManager;
import com.team.progress_tracker.StartupOptions;
import com.team.progress_tracker.user.User;

public class BookDaoImp implements BookDaoInterface {
	private static Connection connection = null;
	private User user;
	
	/*
	 * The DAO for book objects.
	 */
	
	/*
	 * makes sure the currently logged in user is known so that only the books under that user can be retrieved.
	 */
	@Override
	public void establishConnection() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {
			connection = ConnectionManager.getConnection();
		}
		
		user = StartupOptions.getCurrentUser();

	}

	@Override
	public void closeConnection() throws SQLException {
		connection.close();

	}
	/*
	 * assumes a book is in the database and is listed under a current user, and attempts to edit its log; if not, it returns false.
	 */

	@Override
	public boolean update(Book book, double rating, String status) throws ClassNotFoundException, SQLException {
		Statement s;
		boolean success;
		try {
			this.establishConnection();
			s = connection.createStatement();
			String command = "update user_book set rating =" +" " + rating + ", status ='" + status + 
					"' where book_id = " + book.getBook_ID() + " and user_id = " + user.getUser_ID() + ";";
			s.executeUpdate(command);
			success = true;
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Could not find " + book.getTitle() + " in user list!");
			success = false;
		}
		return success;
	}
	/*
	 * adds a new tracker to the user/book join table
	 */
	@Override
	public void add(Book book, double rating, String status) throws ClassNotFoundException, SQLException {
		Statement s;
		try {
			this.establishConnection();
			s = connection.createStatement();
			String command = "insert into user_book (user_id, book_id, rating,status ) values(" +
					user.getUser_ID() + ", " + book.getBook_ID() + ", " 
							+ rating + ", '" + status + "');";
			s.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * gets all books listed under the current user's id.
	 */
	@Override
	public void getAll() throws SQLException, ClassNotFoundException {
		Statement s = null;
		
		try {
			this.establishConnection();
			s = connection.createStatement();
			
			
			String query = "select book.book_id, author, title, rating, status from book join user_book where user_id = " + user.getUser_ID() + ";";
			
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) {
				String author = rs.getString("author");
				String title = rs.getString("title");
				String rating = rs.getString("rating");
				String status = rs.getString("status");
				String bookID = rs.getString("book_id");
				
				System.out.println("User ID: " + user.getUser_ID() + ", Book ID: " + bookID + ", Title: " + title + ", Author: " 
				+ author + ", Rating: " + rating + ", Status: " + status);

			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (s != null) {
					s.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*
	 * finds a book in the database.
	 */
	public Optional<Book> bookSearch(String title) {
		
		Statement s = null;
		Optional<Book> result = Optional.empty();
		
		try {
			this.establishConnection();
			s = connection.createStatement();			
			
			String query = "select * from book where title = '" + title + "';";
			System.out.println(title);
			
			ResultSet rs = s.executeQuery(query);
			if(rs.next()) {
				int id = rs.getInt("book_id");
				String author = rs.getString("author");
				
				result = Optional.of(new Book(title, author));
				result.get().setBook_ID(id);
			}
	
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return result;
	}
	/*
	 * finds a book listed under the current user's id
	 */
	public boolean userBookSearch(Book book) {
		
		Statement s = null;
		boolean result = false;
		
		try {
			this.establishConnection();
			s = connection.createStatement();			
			
			String query = "select * from user_book where book_id = " + book.getBook_ID() + " and user_id = " + user.getUser_ID() + ";";
			
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()) {
				result = true;
				
			}
	
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

}
