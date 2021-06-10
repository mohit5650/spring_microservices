package com.brainmentors.apps.isademo.singletabledemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.brainmentors.apps.isademo.utils.Config;

public class DAO {
	
	public static void save( Employee employee, Student student) {
		
		SessionFactory sf = Config.getSessionFactory();
		Session session = sf.openSession();
		Transaction trans = session.beginTransaction();
		
		session.save(employee);
		session.save(student);
		trans.commit();
		session.close();
		System.out.println("Data Saved....");
		
	}

}
