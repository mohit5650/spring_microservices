package com.brainmentors.apps.isademo.tableperclass;

import com.brainmentors.apps.isademo.tableperclass.DAO;

public class TestISA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(99999, "Brain Mentors", "Ram","Delhi");
		Student stud = new Student(1111, "Java", "Shyam", "Mumbai");
		Person person = new Person("Sohan","Delhi");
		DAO.save(person, emp, stud);	

	}

}
