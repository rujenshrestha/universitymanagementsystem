package com.sresta.university.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentDAO extends DAO{

	public DepartmentDAO(){
		this.tblName = "Department";
	}
	
	/*@Autowired
	private SessionFactory sessionFactory;*/
}
