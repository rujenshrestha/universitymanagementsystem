package com.sresta.university.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.sresta.university.entity.DBObject;

public abstract class DAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected String tblName;
	
	public String getTblName() {
		return tblName;
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}
	
	
	@Transactional
	public void save(DBObject obj){
		System.out.println("save method called "+obj.toString());
		
		Session session = sessionFactory.getCurrentSession();
		session.save(obj);  
		
		
	}
	
	@Transactional
	public <T> List<T> getAll(Class<T> type){
		
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from "+this.tblName); //HQL
		System.out.println("HQL:"+q.getQueryString());
		List<T> l = q.list();
		return l;
	}
	

	@Transactional
	public <T> T get(String var, String value, Class<T> type){
		
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from "+this.tblName+" WHERE "+var+" =:value");
		q.setParameter("value", value);
		System.out.println("HQL:"+q.getQueryString());
		T obj = (T)q.uniqueResult();

		System.out.println(obj.toString());
		return obj;
	}
	
	@Transactional
	public void delete(String var, String value){	
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from "+this.tblName+" where "+var+" = :value");
		q.setParameter("value", value);
		System.out.println("HQL:"+q.getQueryString());
		int result = q.executeUpdate();  
		
	}
	
	@Transactional
	public void update(DBObject obj, String var, String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{

		Session session = sessionFactory.getCurrentSession();
		String[] fields = obj.getAttr();
		StringBuilder sql = new StringBuilder();
		
		sql.append("update "+this.tblName+" set ");
		for(String field : fields){
			sql.append(field+"= :"+field+", ");
		}
		sql.delete(sql.length()-2, sql.length()-1);
		sql.append(" where "+var+" = :value");
		
		Query q = session.createQuery(sql.toString());
		
		for(String field : fields){
			String methodName = "get"+field;
			String fieldValue = (String)obj.getClass().getMethod(methodName).invoke(obj);
			q.setParameter(field, fieldValue);
		}
		q.setParameter("value", value);
		System.out.println("HQL:"+q.getQueryString());
		
		int result = q.executeUpdate();  
	}
}
