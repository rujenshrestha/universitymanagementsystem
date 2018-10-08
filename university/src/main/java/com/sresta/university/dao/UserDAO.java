package com.sresta.university.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sresta.university.entity.User;

@Component
public class UserDAO extends DAO{
	
	public UserDAO(){
		this.tblName = "User";
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	
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
