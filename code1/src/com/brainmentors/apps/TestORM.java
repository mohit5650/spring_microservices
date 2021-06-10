package com.brainmentors.apps;

public class TestORM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		dao.save(new Customer(102, "bnbn",8888));

	}

}
