package com.stu.model;

public class Account {
	private int user_id;
	private String name;
	private String pwd;
	
	
	public int getUser_id() {
		return user_id;
	}
	public String getName() {
		return name;
	}
	public String getPwd() {
		return pwd;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
}
