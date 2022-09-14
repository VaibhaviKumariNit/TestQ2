package com.ex.test.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "sales")
public class Sales {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String fname;
	private String lname;
	private int age;
	
	public Sales() {
		super();
	}

	public Sales(int sid, String fname, String lname, int age) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Sales [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
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
	

}
