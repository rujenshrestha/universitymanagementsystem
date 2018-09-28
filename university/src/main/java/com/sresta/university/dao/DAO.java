package com.sresta.university.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sresta.university.entity.DBObject;

@Component
public class DAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Transactional
	public void save(DBObject obj){
		System.out.println("save method called "+obj.toString());
		
		Session session = sessionFactory.getCurrentSession();
		session.save(obj);  
		
		
	}
	
	/*@Transactional
	public List<DBObject> getAll(){
		
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Student"); //HQL
		List<DBObject> l = (List<DBObject>)q.list();

		System.out.println(l);
		return l;
	}
	
	
	@Transactional
	public Student getStudent(String var, String value){
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Student WHERE "+var+" =:value");
		query.setParameter("value", value);
		Student std = (Student) query.uniqueResult();

		System.out.println(std.toString());
		return std;
	}
	
	@Transactional
	public void updateStudent(Student std){
		System.out.println("saveStudent method called "+std.toString());
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update Student set firstName = :firstName, middleName = :middleName,"
										+ "lastName = :lastName, gender = :gender "
										+ "where uId = :uId");
		query.setParameter("firstName", std.getFirstName());
		query.setParameter("middleName", std.getMiddleName());
		query.setParameter("lastName", std.getLastName());
		query.setParameter("gender", std.getGender());
		query.setParameter("uId", std.getuId());
		int result = query.executeUpdate();  
		
		
	}
	
	@Transactional
	public void deleteStudent(String uId){	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Student where uId = :uId");
		query.setParameter("uId", uId);
		int result = query.executeUpdate();  
		
	}
	
	@Transactional
	public List<String> getStudentByName(String studentName){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select concat(firstName,' ',middleName,' ',lastName) as name "
										+ "from Student "
										+ "where concat(firstName,' ',middleName,' ',lastName) like :name"); 
		query.setParameter("name",studentName + "%");
		return query.list();
	}*/

}
