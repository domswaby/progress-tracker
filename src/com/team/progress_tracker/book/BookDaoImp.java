package com.team.progress_tracker.book;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.team.progress_tracker.ConnectionManager;
import com.team.progress_tracker.user.User;

public class BookDaoImp implements BookDaoInterface {
	private static Connection connection = null;
	private User user;
	@Override
	public void establishConnection() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {
			connection = ConnectionManager.getConnection();
		}

	}
	
	public void getUser(User user) {
		this.user = user;
	}

	@Override
	public void closeConnection() throws SQLException {
		connection.close();

	}

	@Override
	public boolean update(Book book, double rating, String status) throws ClassNotFoundException, SQLException {
		Statement s;
		boolean success;
		try {
			this.establishConnection();
			s = connection.createStatement();
			String command = "INSERT INTO user_book (user_id, book_id, rating, status) values(" +
			user.getUser_ID() + ", " + book.getBook_ID() + ", " 
					+  rating + ", '"+ status  + "');";
			s.executeUpdate(command);
			success = true;
		} catch (SQLException e) {
			//e.printStackTrace();
			System.out.println("Could not find " + book.getTitle() + " in the library!");
			success = false;
		}
		return success;
	}

	@Override
	public void add(Book book, double rating, String status) throws ClassNotFoundException, SQLException {
		Statement s;
		try {
			this.establishConnection();
			s = connection.createStatement();
			String command = "select * from user_book where user_id = " + user.getUser_ID() + ";";
			s.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> getAll() throws SQLException, ClassNotFoundException {
		Statement s = null;
		List<Book> result = new ArrayList<Book>();
		
		try {
			this.establishConnection();
			s = connection.createStatement();
			
			
			String query = "select book.book_id, author, title, rating, status from book join user_book where user_id = " + user.getUser_ID() + ";";
			
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) {
				String author = rs.getString("author");
				String title = rs.getString("title");

				Book book = new Book(author, title);
				result.add(book);
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
		return result;
	}

}
