package com.onlinebookstore.model;

public class Users {
	 
	private int userId;
	private String userName;
	private String userAddress;
	private String userEmailId;
	private String userContactNo;
	private String userPassword;
	private boolean isAdmin;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserContactNo() {
		return userContactNo;
	}
	public void setUserContactNo(String userContactNo) {
		this.userContactNo = userContactNo;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", userEmailId="
				+ userEmailId + ", userContactNo=" + userContactNo + ", userPassword=" + userPassword + ", isAdmin="
				+ isAdmin + "]";
	}
	
	
}
