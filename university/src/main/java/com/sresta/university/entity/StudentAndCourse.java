package com.sresta.university.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class StudentAndCourse extends DBObject {
	
	@EmbeddedId
	private StudentAndCoursePK stdCrsePK;
	private String grade;
	
	public StudentAndCourse(){}
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
