package com.sresta.university.dao;


import org.springframework.stereotype.Component;

@Component
public class StudentAndCourseDAO extends DAO{
	
	public StudentAndCourseDAO(){
		this.tblName = "StudentAndCourse";
	}
}
