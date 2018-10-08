package com.sresta.university.dao;

import org.springframework.stereotype.Component;

@Component
public class FacultyDAO extends DAO{

	public FacultyDAO(){
		this.tblName = "Faculty";
	}

}
