package com.placeorder.model;

public class UserAccount {

	private int accountId;
	private String userName;
	private String password;
	private String location;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "UserAccount [accountId=" + accountId + ", userName=" + userName + ", password=" + password
				+ ", location=" + location + "]";
	}
	
	
	

}
