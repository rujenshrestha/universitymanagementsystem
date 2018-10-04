package com.sresta.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User extends DBObject{
	
	@Id
	private int ssn;
	private String name;
	private String username;
	private String password;
	private String role;
	
	public User(){
		String[] field = {"Name","Username","Password","Role"};
		this.setAttr(field);
	}
	
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	@Override
	public String toString() {
		return "User [ssn=" + ssn + ", name=" + name + ", username=" + username + ", password=" + password + ", role="
				+ role + "]";
	}
	
}
