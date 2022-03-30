// Coded by Katelyn Vanderwolde
// Last Modified 3/14/22
// Basic storage class for saving user

package org.openjfx;

public class User {
	
	protected String firstName; 
	protected String lastName;
	protected String userName;
	protected String password;
	protected int userId;
	
	
	public User(String newFirstName, String newLastName, String newUserName, String newPassword, int newUserId) {
		this.firstName = newFirstName;
		this.lastName = newLastName;
		this.userName = newUserName;
		this.password = newPassword;
		this.userId = newUserId;
		
		
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
