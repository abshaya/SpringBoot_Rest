package com.javatpoint.server.main.usermanagement;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;


public class User {
	
	private int UserID;
	@Size(min=5)
	private String UserName;
	@Past
	private Date dob;
	
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
	
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public User() {
		
	}
	public User(int userID, String userName, Date dob) {
		this.UserID = userID;
		this.UserName = userName;
		this.dob = dob;
	}
	@Override  
	public String toString()   
	{  
	//return "User [id=" + id + ", name=" + name + ", dob=" + dob + "]";  
	return String.format("User [id=%s, name=%s, dob=%s]", UserID, UserName, dob);  
	}  
}
