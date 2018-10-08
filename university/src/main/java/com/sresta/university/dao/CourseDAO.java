package com.sresta.university.dao;

import org.springframework.stereotype.Component;

@Component
public class CourseDAO extends DAO{

	public CourseDAO(){
		this.tblName = "Course";
	}
}
