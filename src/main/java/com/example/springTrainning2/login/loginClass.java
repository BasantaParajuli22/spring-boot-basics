package com.example.springTrainning2.todotask.Login;

import java.util.Date;

public class loginClass {
	
	private String username;
	private String password;
	private String userid;
	private Date date;
	
	public loginClass(String username) {
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
