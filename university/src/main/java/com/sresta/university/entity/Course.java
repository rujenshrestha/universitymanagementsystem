package com.sresta.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Course extends DBObject{
	
	@Id
	private String crseId;
	private String crseName;
	private String level;
	private String deptId;
	private String degId;
	
	public Course() {
		String[] field = {"CrseName","Level","DeptId","DegId"};
		this.setAttr(field);
	}

	public String getCrseId() {
		return crseId;
	}

	public void setCrseId(String crseId) {
		this.crseId = crseId;
	}

	public String getCrseName() {
		return crseName;
	}

	public void setCrseName(String crseName) {
		this.crseName = crseName;
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

	public String getDegId() {
		return degId;
	}

	public void setDegId(String degId) {
		this.degId = degId;
	}

	@Override
	public String toString() {
		return "Course [crseId=" + crseId + ", crseName=" + crseName + ", level=" + level + ", deptId=" + deptId
				+ ", degId=" + degId + "]";
	}
	

}
