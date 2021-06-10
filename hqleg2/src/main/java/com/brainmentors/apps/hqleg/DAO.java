package com.brainmentors.apps.hqleg;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DAO {
	
	
	public static void callNamedNativeQuery(double balance) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Customer> query = session.createNamedQuery("iamnative");
		query.setParameter("bal",balance);
		List<Customer> customerList = query.list();
		System.out.println(customerList);
		session.close();
	}
	
	public static void findByCustomerId(int id) {
			SessionFactory sessionFactory = Config.getSessionFactory();
			Session session = sessionFactory.openSession();
			Query<Customer> query = session.createNamedQuery("findByCustomerId");
			query.setParameter("customerid",id);
			Customer customer = query.getSingleResult();
			System.out.println(customer);
			session.close();
			//List<Customer> customerList = query.list();
			
	}
	
	public static void sortedRecords() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query<Customer> query = session.createNamedQuery("sortby");
		List<Customer> customerList = query.list();
		
		System.out.println(customerList);
		session.close();
		//List<Customer> customerList = query.list();
		
}
	
	public static void save(Customer customer) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		session.close();
		System.out.println("Data Saved...");
	}
	
	static void getCustomer(int id) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer obj = session.get(Customer.class, id);
		if(obj==null) {
			System.out.println("Not Found");
			return ;
		}
		else {
			System.out.println("Found "+obj);
		}
		session.close();
		
	}
	
	
	static void deleteCustomers() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("delete from Customer where balance>100");
		int count = query.executeUpdate();
		transaction.commit();
		session.close();
		if(count>0) {
			System.out.println("Record Deleted.. "+count);
		}
		else {
			System.out.println("No Delete....");
		}
		
		
	}
	
	static void updateCustomers() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update Customer set balance=100 where city='Delhi'");
		int count = query.executeUpdate();
		transaction.commit();
		session.close();
		if(count>0) {
			System.out.println("Record Updated.. "+count);
		}
		else {
			System.out.println("No Update....");
		}
		
		
	}
	
	
	static void agg() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		//Query query = session.createQuery("select sum(customer.balance)  from Customer customer ");
		//Query query = session.createQuery("select max(customer.balance)  from Customer customer ");
		//Query query = session.createQuery("select min(customer.balance)  from Customer customer ");
		//Query query = session.createQuery("select count(customer.balance)  from Customer customer ");
		Query query = session.createQuery("select avg(customer.balance)  from Customer customer ");
		List<Map<String, Integer>> list = query.list();
		System.out.println(list.get(0));
		
		
		session.close();
		
	}
	
	static void groupBy() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Asc
		//Query query = session.createQuery("from Customer customer order by customer.balance");
		// Desc
		Query query = session.createQuery("select new map(customer.city, sum(customer.balance)) from Customer customer group by customer.city");
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List<Map<String, Integer>> list = query.list();
		System.out.println(list);
		//System.out.println("List is "+list);
		
		session.close();
		
	}
	
	static void getCustomerOrderByMultiple() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Asc
		//Query query = session.createQuery("from Customer customer order by customer.balance");
		// Desc
		Query query = session.createQuery("from Customer customer order by customer.balance desc, customer.name");
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	static void sqlInjection(String bal) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select customer.name from Customer customer where customer.balance>"+bal);
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	static void parameterWayNamed(String bal) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select customer.name from Customer customer where customer.balance>:balparam");
		query.setDouble("balparam", Double.parseDouble(bal));
		//query.setDouble(0, Double.parseDouble(bal));
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	static void parameterWayPosition(String bal) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select customer.name from Customer customer where customer.balance>?");
		query.setDouble(0, Double.parseDouble(bal));
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	static void getCustomerOrderBy() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		// Asc
		//Query query = session.createQuery("from Customer customer order by customer.balance");
		// Desc
		Query query = session.createQuery("from Customer customer order by customer.balance desc");
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	
	static void getCustomerProjection() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select customer.name from Customer customer");
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List<String> list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	static void getCustomerProjectionWhere() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select customer.name from Customer customer where customer.balance>100");
//		query.setFirstResult(0);
//		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
	
	static void getCustomers() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Customer");
		query.setFirstResult(0);
		query.setMaxResults(5);
		List list = query.list();
		System.out.println("List is "+list);
		session.close();
		
	}
}
