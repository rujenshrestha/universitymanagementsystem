package com.sresta.university.entity;


public abstract class DBObject {
	protected String[] attr;

	public String[] getAttr() {
		return attr;
	}

	public void setAttr(String[] attr) {
		this.attr = attr;
	}
}
