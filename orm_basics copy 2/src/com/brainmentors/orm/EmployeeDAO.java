package com.brainmentors.orm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO {
	SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	
	public void save() {
		Employee emp = new Employee( "Tim1", 9999);
		Session session = sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(emp);
		//session.saveOrUpdate(emp);
		session.persist(emp);
		emp.setSalary(432434);
		
		trans.commit();
		
		session.close();
		System.out.println("Data Saved....");
	}
	
	public void remove(int id) {
		Session session = sessionFactory.openSession();
		Employee emp = read(id);
		if(emp==null) {
			System.out.println("Id Not Exist");
			return;
		}
		Transaction trans = session.beginTransaction();
		session.delete(emp);
		trans.commit();
		session.close();
		System.out.println("Record Deleted...");
		
	}
	
	public void update(int id) {
		Session session = sessionFactory.openSession();
		Employee emp = read(id);
		if(emp==null) {
			System.out.println("Id Not Exist");
			return;
		}
		emp.setSalary(emp.getSalary() + 10000);
		Transaction trans = session.beginTransaction();
		session.update(emp);
		trans.commit();
		session.close();
		System.out.println("Record Deleted...");
		
	}
	
	public Employee read(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, id);
		//Employee employee = session.load(Employee.class, id);
		System.out.println("SQL ??????");
		System.out.println("Employee Data is "+employee);
		session.close();
		return employee;
		
	}
	
	public void update() {
		
	}

}
