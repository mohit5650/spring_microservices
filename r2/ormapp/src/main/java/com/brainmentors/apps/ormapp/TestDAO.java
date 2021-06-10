package com.brainmentors.apps.ormapp;

import java.util.ArrayList;
import java.util.List;

import com.brainmentors.apps.ormapp.utils.Item;


public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		DAO dao = new DAO();
//		Customer customer = new Customer();
//		customer.setId(1001);
//		customer.setName("Abcd");
//		customer.setBalance(99999);
//		dao.save(customer);
//		DAO dao = new DAO();
//		Student student = new Student();
//		student.setName("Ram");
//		student.setAge(21);
//		Course course = new Course();
//		course.setName("Java");
//		course.setDuration(20);
//		student.setCourse(course);
//		//course.setStudent(student);
//		dao.saveStudent(student, course);
//		DAO dao = new DAO();
//		
//		ITStudent student = new ITStudent();
//		student.setName("Ram");
//		student.setAge(21);
//		List<Course> courseList = new ArrayList<Course>();
//		courseList.add(new Course("Java",20));
//		courseList.add(new Course("JS",16));
//		courseList.add(new Course("ReactJS",20));
//		student.setCourses(courseList);
//		dao.saveStudent(student);
		
		DAO dao = new DAO();
		Customer customer = new Customer();
		customer.setName("ABC");
		customer.setBalance(99999);
		List<Item> items = new ArrayList<>();
		items.add(new Item("A",222));
		items.add(new Item("B",322));
		items.add(new Item("C",422));
		customer.setItems(items);
		dao.save(customer);
		
		
		
		
		
		
		
		
	}

}
