package com.sresta.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Degree extends DBObject{
	
	@Id
	private String degId;
	private String degName;
	private String level;
	private String deptId;

	
	public Degree() {
		String[] field = {"DegName","Level","DeptId"};
		this.setAttr(field);
	}


	public String getDegId() {
		return degId;
	}


	public void setDegId(String degId) {
		this.degId = degId;
	}


	public String getDegName() {
		return degName;
	}


	public void setDegName(String degName) {
		this.degName = degName;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getDeptId() {
		return deptId;
	}


	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}


	@Override
	public String toString() {
		return "Degree [degId=" + degId + ", degName=" + degName + ", level=" + level + ", deptId=" + deptId + "]";
	}
	

}
