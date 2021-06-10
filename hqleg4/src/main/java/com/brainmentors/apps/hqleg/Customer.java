package com.brainmentors.apps.hqleg;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name="customer_details")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
//@NamedQueries({
//	@NamedQuery(name="findByCustomerId",query="from Customer customer where id=:customerid",timeout=10,fetchSize=10,comment="Customer Record Fetch By Id", flushMode=FlushModeType.AUTO),
//	@NamedQuery(name="sortby",query="from Customer customer order by customer.balance desc")
//}
//		)
//@NamedNativeQueries({
//	@NamedNativeQuery(name="iamnative",query="select * from customer_details where balance>=:bal",resultClass=Customer.class)
//})


public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double balance;
	//@Transient
	private String city;
	
	public Customer() {}
	public Customer(String name, double balance , String city) {
		this.name  = name;
		this.balance = balance;
		this.city = city;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", balance=" + balance + ", city=" + city + "]\n";
	}
	

}
