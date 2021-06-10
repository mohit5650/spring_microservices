package com.brainmentors.apps;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;
@Entity
@Table(name = "customer_mst")
public class Customer {
	@Id
	
	private int id;
	@Column( name = "customername",nullable = false,length = 30,unique = true,updatable = true)
	private String name;
	private double balance;
	@Temporal(TemporalType.TIMESTAMP)
	private Date doj;
	@Type(type = "yes_no")
	private boolean active;
	
	@Transient
	private int cvv;
	
	public Customer(){
		
	}
	public Customer(int id, String name, double balance) {
		this.id = id;
		this.name = name;
		this.balance= balance;
		this.active=false;
		this.doj = new Date();
		
	}
	
	
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
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
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + ", doj=" + doj + ", active=" + active
				+ "]";
	}
	
	
}
