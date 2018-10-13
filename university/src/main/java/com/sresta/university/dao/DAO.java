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
	public <T> List<T> getAllResultFields(Class<T> type, String[] fields){
		
		Session session = sessionFactory.getCurrentSession();
		StringBuilder sql = new StringBuilder();
		sql.append("select");
		
		for(String field : fields){
			sql.append(" "+field+",");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(" from "+this.tblName);
		System.out.println("SQL:"+sql.toString());
		Query q = session.createQuery(sql.toString()); //HQL
		System.out.println("HQL:"+q.getQueryString());
		List<T> l = q.list();
		
		
		return l;
	}
	

	@Transactional
	public <T> T get(String var, String value, Class<T> type){
		// Search by primary key or unique key; for returning only one row
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from "+this.tblName+" WHERE "+var+" =:value");
		q.setParameter("value", value);
		System.out.println("HQL:"+q.getQueryString());
		T obj = (T)q.uniqueResult();

		System.out.println(obj.toString());
		return obj;
	}
	
	@Transactional
	public <T> List<T> getByField(String var, String value, Class<T> type){
		// Search by any key; for returning one/more row
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from "+this.tblName+" WHERE "+var+" =:value");
		q.setParameter("value", value);
		System.out.println("HQL:"+q.getQueryString());
		List<T> l = q.list();

		return l;
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
		
		System.out.println(obj.toString());
		Session session = sessionFactory.getCurrentSession();
		String[] fields = obj.getAttr();
		StringBuilder sql = new StringBuilder();
		
		sql.append("update "+this.tblName+" set ");
		for(String field : fields){
			sql.append(field+" = :"+field+", ");
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
	
	@Transactional
	public  String getName(String tblName, String attrName, String var, String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("select o."+attrName+" from "+tblName+" o where o."+var+" =:value");
		q.setParameter("value", value);
		System.out.println("HQL:"+q.getQueryString());
		String resultValue = (String)q.uniqueResult();
		return resultValue;
	}
	
	@Transactional
	public List<String> getEntityByName(String var, String value){
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query = session.createQuery("select "+var+" as name from "+this.tblName+ 
										  " where "+var+" like :name"); 
		query.setParameter("name",value + "%");
		return query.list();
	}
}
