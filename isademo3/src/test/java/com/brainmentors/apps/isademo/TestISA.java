package com.brainmentors.apps.isademo;

import com.brainmentors.apps.isademo.utils.DAO;

public class TestISA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp = new Employee(99999, "Brain Mentors", "Ram");
		DAO.save(emp);

	}

}
