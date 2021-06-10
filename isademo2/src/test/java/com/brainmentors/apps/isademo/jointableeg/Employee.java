package com.brainmentors.apps.isademo.jointableeg;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employee_master")
public class Employee extends Person {

	private double salary;
	private String companyName;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(double salary, String companyName, String name, String address) {
		super(name, address);
		this.salary= salary;
		this.companyName = companyName;
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
