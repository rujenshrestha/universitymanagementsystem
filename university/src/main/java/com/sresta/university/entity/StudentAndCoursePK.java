package com.sresta.university.entity;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class StudentAndCoursePK implements Serializable {
	
	protected String uId;
	protected String crseId;
	
	public StudentAndCoursePK(){}
	
	public StudentAndCoursePK(String uId, String crseId){
		this.uId = uId;
		this.crseId = crseId;
	}
}
