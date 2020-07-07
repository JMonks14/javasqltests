package com.qa;

public class Customer {
	
	private int ID;
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	
	Customer() {
		super();
	}

	Customer(String first_name, String last_name, String username, String password) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
	}

	int getID() {
		return ID;
	}

	void setID(int iD) {
		ID = iD;
	}

	String getFirst_name() {
		return first_name;
	}

	void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	String getLast_name() {
		return last_name;
	}

	void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	String getUsername() {
		return username;
	}

	void setUsername(String username) {
		this.username = username;
	}

	String getPassword() {
		return password;
	}

	void setPassword(String password) {
		this.password = password;
	}
	
	String inString() {
		return "INSERT INTO Customers(first_name, last_name, username, password) Values ('" + this.getFirst_name() + 
				"','" + this.getLast_name() + "','" + this.getUsername() + "','" + this.getPassword() + "')";
	}

}
