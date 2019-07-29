package com.studies.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class userrole implements Serializable{
							     
	@Id @GeneratedValue
	private Long id;
	
	private String role;
	private String usr;
	public userrole(String role, String usr) {
		super();
		this.role = role;
		this.usr = usr;
	}
	public userrole() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsr() {
		return usr;
	}
	public void setUsr(String usr) {
		this.usr = usr;
	}
	
	
}
