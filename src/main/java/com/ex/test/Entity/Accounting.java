package com.ex.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "accounting")
public class Accounting {
	@Id
	private int id;
	private String fname;
	private String lname;
	private int age;
	public Accounting() {
		super();
		
	}
	public Accounting(String fname, String lname, int age, int id) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Accounting [fname=" + fname + ", lname=" + lname + ", age=" + age + ", id=" + id + "]";
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
