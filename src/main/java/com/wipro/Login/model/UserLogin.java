package com.wipro.Login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "login")
public class UserLogin {
	@Id
	@Column(name = "userid")
	private int userId;
	@Column(name = "password")
	private String password;
	@Column(name = "usertype")
	@Enumerated(EnumType.STRING)
	private userType userType;

	public UserLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserLogin(int userId, String password, userType userType) {
		super();
		this.userId = userId;
		this.password = password;
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public userType getUserType() {
		return userType;
	}

	public void setUserType(userType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserLogin [userId=" + userId + ", password=" + password + ", userType=" + userType + "]";
	}

}
