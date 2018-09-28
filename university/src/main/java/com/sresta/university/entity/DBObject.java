package com.sresta.university.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DBObject {

	@Id
	protected String tblName;

	public String getTblName() {
		return tblName;
	}

	public void setTblName(String tblName) {
		this.tblName = tblName;
	}
}
