package com.sresta.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty extends DBObject{
	
	@Id
	private String facultyId;
	private String name;
	private long ssn;
	private String gender;
	private String email;
	private long phoneNo;
	private String post;
	private String deptId;
	
	public Faculty() {
		String[] field = {"Name","Ssn","Gender","Email","PhoneNo","Post","DeptId"};
		this.setAttr(field);
	}

	public String getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(String facultyId) {
		this.facultyId = facultyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSsn() {
		return ssn;
	}

	public void setSsn(long ssn) {
		this.ssn = ssn;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", name=" + name + ", ssn=" + ssn + ", gender=" + gender + ", email="
				+ email + ", phoneNo=" + phoneNo + ", post=" + post + ", deptId=" + deptId + "]";
	}
	


}
