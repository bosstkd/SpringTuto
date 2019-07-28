package com.studies.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class user implements Serializable{

	
	@Id
	private String userName;
	private String password;
	private boolean active;
	
	public user(String userName, String password, boolean active) {
		super();
		this.userName = userName;
		this.password = password;
		this.active = active;
	}
	
	public user() {
		super();
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
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
