package com.brainmentors.apps.isademo;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="emp_mst")
@AttributeOverride(name="address",column = @Column(name="office_address"))
public class Employee extends Person {
	private double salary;
	private String companyName;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(double salary, String companyName, String name) {
		super(name);
		this.salary = salary;
		this.companyName = companyName;
		this.setAddress("Mumbai");
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
}
