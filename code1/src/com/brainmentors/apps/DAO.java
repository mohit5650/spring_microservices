package com.brainmentors.apps;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class DAO {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void save(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(customer);
		trans.commit();
		session.close();
		
		System.out.println("Customer Added..");
	}
	
	public void update(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		if(findById(customer.getId())!=null) {
			session.update(customer);
			System.out.println("Updated...");
		}
		else {
			System.out.println("Id Not Exist so can't update");
		}
		
		trans.commit();
		session.close();
		
		System.out.println("Customer Added..");
	}
	
	
	public Customer findById(int id) {
		Session session = sessionFactory.openSession();
		Customer customer  = session.get(Customer.class, id);
		session.close();
		return customer;
	}
	
	
	public void read(int id) {
		Session session = sessionFactory.openSession();
		Customer customer  = session.get(Customer.class, id);
		session.close();
		System.out.println("Customer Read .."+customer);
	}
	
}
