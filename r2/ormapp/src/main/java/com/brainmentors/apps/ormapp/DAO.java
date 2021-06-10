package com.brainmentors.apps.ormapp;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.brainmentors.apps.ormapp.utils.Config;
import com.brainmentors.apps.ormapp.utils.Course;
import com.brainmentors.apps.ormapp.utils.ITStudent;
import com.brainmentors.apps.ormapp.utils.Student;



public class DAO {

	
	public void save(Customer customer) {
		Session session = Config.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.persist(customer);
		session.flush();
		session.clear();
		trans.commit();
		session.close();
		
		System.out.println("Customer Added..");
	}
	
	public void saveStudent(ITStudent student) {
		Session session = Config.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.persist(student);
//		for(Course course : student.getCourses()) {
//		session.save(course);
//		}
		session.flush();
		session.clear();
		trans.commit();
		session.close();
		
		System.out.println("Student Added..");
	}
	
	public void saveStudent(Student student, Course course) {
		Session session = Config.getSessionFactory().openSession();
		Transaction trans = session.beginTransaction();
		session.save(student);
		session.save(course);
		trans.commit();
		session.close();
		
		System.out.println("Student Added..");
	}
	
	
	
	
	
	
}
