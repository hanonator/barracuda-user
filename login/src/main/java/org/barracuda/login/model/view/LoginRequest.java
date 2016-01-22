package org.barracuda.login.model.view;

public class LoginRequest {

	/**
	 * The user name 
	 */
	private String username;
	
	/**
	 * The display name
	 */
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
