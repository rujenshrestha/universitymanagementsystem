package com.sresta.university.dao;

import org.springframework.stereotype.Component;

@Component
public class DegreeDAO extends DAO{

	public DegreeDAO(){
		this.tblName = "Degree";
	}
}
