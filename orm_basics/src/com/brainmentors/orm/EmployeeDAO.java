package com.brainmentors.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void save() {
		Employee emp = new Employee(1002, "Ramesh", 9999);
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(emp);
		trans.commit();
		
		session.close();
		System.out.println("Data Saved....");
	}
	
	public void remove() {
		
	}
	
	public void read() {
		
	}
	
	public void update() {
		
	}

}
