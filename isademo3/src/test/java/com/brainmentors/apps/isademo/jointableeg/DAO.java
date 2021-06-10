package com.brainmentors.apps.isademo.jointableeg;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.brainmentors.apps.isademo.utils.Config;

public class DAO {
	
	public static void save(Person person, Employee employee, Student student) {
		
		SessionFactory sf = Config.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(person);
		session.save(employee);
		session.save(student);
		trans.commit();
		session.close();
		System.out.println("Data Saved....");
		
	}
	
public static void saveLOB(LargeObjects largeObjects) {
		
		SessionFactory sf = Config.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		session.save(largeObjects);
		trans.commit();
		session.close();
		System.out.println("Data Saved....");
		
	}

}
