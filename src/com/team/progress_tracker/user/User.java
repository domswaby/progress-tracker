package com.team.progress_tracker.user;


public class User {
	
	/*
	 * A simple user object.
	 */

	private int user_ID;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private boolean is_admin;
	

	public User(int user_ID,String first_name, String last_name, String username, String password, boolean is_admin) {
		this.user_ID = user_ID;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.is_admin = is_admin;
	}
	
	public String toString() {
		return "User [UserID=" + user_ID + ", name =" + first_name + last_name + ", username =" + username + ", password =" + password
				+ ", Is Admin =" + is_admin + "]";
	}
	
	public int getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(int user_ID) {
		this.user_ID = user_ID;
	}

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isIs_admin() {
		return is_admin;
	}
	public void setIs_admin(boolean is_admin) {
		this.is_admin = is_admin;
	}
	
}
