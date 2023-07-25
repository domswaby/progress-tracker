package com.team.progress_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	
	private static final String URL = "jdbc:mysql://localhost:3306/book_database";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	private static Connection connection = null;
	
	private static void createConnection() {
		
		try {
			Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			connection = conn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if (connection == null) {
			createConnection();
		}
		return connection;	
	}

	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println("Connecton Established!");
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}