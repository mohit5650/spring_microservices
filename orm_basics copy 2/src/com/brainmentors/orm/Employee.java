package com.brainmentors.orm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "emp_mst")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "ename",length = 50,nullable = false,unique = true)
	private String name;
	@Type(type="yes_no")
	private boolean att;
	
	@Temporal(TemporalType.TIMESTAMP)
	//@Temporal(TemporalType.TIME)
	//@Temporal(TemporalType.DATE)
	private Date doj;
	
	private double salary;
	
	@Transient
	private String password;
	
	
	public Employee() {}
	
	
	
	public Date getDoj() {
		return doj;
	}



	public void setDoj(Date doj) {
		this.doj = doj;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public Employee( String name, double salary) {
		super();
		//this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	
	public boolean isAtt() {
		return att;
	}

	public void setAtt(boolean att) {
		this.att = att;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
	
	
	

}
