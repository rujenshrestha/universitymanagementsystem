package com.sresta.university.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class DegreeDAO extends DAO{

	public DegreeDAO(){
		this.tblName = "Degree";
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<String> getDegreeByName(String degreeName){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select degName as name from Degree "
										+ "where degName like :name"); 
		query.setParameter("name",degreeName + "%");
		return query.list();
	}
}
