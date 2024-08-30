package com.example.springTrainning2.login;

public class RegisterClass {
	
	private String username;
	private String password;
	private String userid;
	private Date date;
	
	public RegisterClass(String username) {
		this.username = username;
		// this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}

	public String getUserid() {
		return userid;
	}

	public Date getDate() {
		return date;
	}
}
