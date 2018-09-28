package com.sresta.university.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sresta.university.entity.Student;
import com.sresta.university.entity.User;

@Component
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void saveUser(User user){
		System.out.println("saveStudent method called "+user.toString());
		
		Session session = sessionFactory.getCurrentSession();
		session.save(user);  
		
		
	}
	
	@Transactional
	public List<User> getAllUser(){
		
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User"); //HQL
		List<User> l = (List<User>)q.list();

		System.out.println(l);
		return l;
	}
	
	
	@Transactional
	public User getUser(String var, String value){
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User WHERE "+var+" =:value");
		query.setParameter("value", value);
		User user = (User) query.uniqueResult();

		System.out.println(user.toString());
		return user;
	}
	
	@Transactional
	public void updateUser(User user){
		
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("update User set name = :name, username = :username,"
										+ "password = :password, role = :role "
										+ "where ssn = :ssn");
		query.setParameter("name", user.getName());
		query.setParameter("username", user.getUsername());
		query.setParameter("password", user.getPassword());
		query.setParameter("role", user.getRole());
		query.setParameter("ssn", user.getSsn());
		int result = query.executeUpdate();  
		
		
	}
	
	@Transactional
	public void deleteUser(String ssn){	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from User where ssn = :ssn");
		query.setParameter("ssn", ssn);
		int result = query.executeUpdate();  
		
	}
	
	@Transactional
	public User loginUser(String username, String password){	
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User WHERE username =:username and password =:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		User user = (User) query.uniqueResult();  
		return user;
	}
}
