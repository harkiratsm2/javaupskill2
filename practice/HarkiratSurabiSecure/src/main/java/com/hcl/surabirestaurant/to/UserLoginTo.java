package com.hcl.surabirestaurant.to;

public class UserLoginTo {	// TO class to store the User Login credentials

	private String username;
	private String password;
	private String role;
	
	public UserLoginTo() {
		super();
	}

	public UserLoginTo(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
