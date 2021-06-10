package com.brainmentors.apps.isademo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.brainmentors.apps.isademo.Employee;

public class DAO {
	
	public static void save(Employee employee) {
		
		SessionFactory sf = Config.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(employee);
		trans.commit();
		session.close();
		System.out.println("Data Saved....");
		
	}

}
