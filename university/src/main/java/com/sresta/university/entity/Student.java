package com.sresta.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student extends DBObject{
	
	@Id
	private String uId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private String deptId;
	private String level;
	
	public Student() {
		String[] field = {"FirstName","MiddleName","LastName","Gender"};
		this.setAttr(field);
	}
	
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}


	@Override
	public String toString() {
		return "Student [uId=" + uId + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", gender=" + gender + ", deptId=" + deptId + ", level=" + level + "]";
	}


	

}
