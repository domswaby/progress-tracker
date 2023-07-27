package com.team.progress_tracker.user;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import com.team.progress_tracker.ConnectionManager;

public class UserDaoImp implements UserDaoInterface {
	
	private static Connection connection = null;

	@Override
	public void establishConnection() throws ClassNotFoundException, SQLException {
		
		if(connection == null) {
			connection = ConnectionManager.getConnection();
		}

	}

	@Override
	public void closeConnection() throws SQLException {
		connection.close();

	}

	@Override
	public Optional<User> login(String username) throws ClassNotFoundException, SQLException {	
		this.establishConnection();
		return search(username);
	}

	@Override
	public int signup(User user) throws ClassNotFoundException, SQLException {
		Statement s;
		try {
			this.establishConnection();
			s = connection.createStatement();
			String command = "INSERT INTO user (first_name, last_name, username, pass, is_admin) values('" +
			user.getFirst_name() + "', '" + user.getLast_name() + "', '" 
					+ user.getUsername() + "', '"+ user.getPassword() + "', '" + "0" + "');";
			s.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return this.search(user.getUsername()).get().getUser_ID();
	}
	
	@Override
	public Optional<User> search(String username) {
		Statement s = null;
		Optional<User> result = Optional.empty();
		
		try {
			this.establishConnection();
			s = connection.createStatement();			
			
			String query = "select * from user where username = '" + username + "';";
			
			ResultSet rs = s.executeQuery(query);
			
			if(rs.next()) {
				int id = rs.getInt("user_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String password = rs.getString("pass");
				boolean isAdmin = rs.getBoolean("is_admin");
				
				result = Optional.of(new User(id, firstName, lastName,username, password, isAdmin));
			}
	
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}

}
