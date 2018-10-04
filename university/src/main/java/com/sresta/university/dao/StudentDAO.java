package com.sresta.university.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sresta.university.entity.Student;

@Component
public class StudentDAO extends DAO{
	
	public StudentDAO(){
		this.tblName = "Student";
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public List<String> getStudentByName(String studentName){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select concat(firstName,' ',middleName,' ',lastName) as name "
										+ "from Student "
										+ "where concat(firstName,' ',middleName,' ',lastName) like :name"); 
		query.setParameter("name",studentName + "%");
		return query.list();
	}
}
