package com.brainmentors.apps.hqleg;

import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.query.Query;

public class DAO {
	
	
	public static void secondLevelCache(int id ) {
		System.out.println("First Time ");
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer ram  = session.load(Customer.class, id);
		System.out.println(ram);
		session.close();
		session = sessionFactory.openSession();
		System.out.println("Again Fetch the Data...");
		Customer ram2 = session.load(Customer.class,id);
		System.out.println(ram2);
		
		
		session.close();
	}
	
	public static void firstLevelCache(int id ) {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer ram  = session.load(Customer.class, id);
		System.out.println(ram);
		System.out.println("Again Fetch the Data...");
		ram = session.load(Customer.class,id);
		System.out.println(ram);
		//session.evict(ram); // clear ram from the cache
		session.clear(); // Clear all from the cache
		System.out.println("After Clear ....");
		ram = session.load(Customer.class,id);
		System.out.println(ram);
		session.close();
	}
	
	public static void criteria() {
		SessionFactory sessionFactory = Config.getSessionFactory();
		Session session = sessionFactory.openSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteraQuery = criteriaBuilder.createQuery(Customer.class); 
		Root<Customer> root = criteraQuery.from(Customer.class); // root contain the reference of Customer Entity
		//criteraQuery.select(root); // select * from customer;
		//criteraQuery.select(root).where(criteriaBuilder.gt(root.get("balance"),200)); // select * from customer where balance>200
		//criteraQuery.select(root).where(criteriaBuilder.like(root.get("name"),"A%")); // select * from customer where name like 'A%'
		//criteraQuery.select(root).where(criteriaBuilder.between(root.get("balance"),200,4000)); // select * from customer where balance >200 and balance<4000
		//criteraQuery.select(root).where(criteriaBuilder.isNull(root.get("name")));
		//criteraQuery.select(root).where(criteriaBuilder.isNotNull(root.get("name")));
		
		Predicate [] pre = new Predicate[2]; // 2 condition
		pre[0] = criteriaBuilder.gt(root.get("balance"),200);
		pre[1] = criteriaBuilder.like(root.get("name"),"%i%");
		//criteraQuery.select(root).where(criteriaBuilder.and(pre));
		criteraQuery.multiselect(criteriaBuilder.sum(root.get("balance")),criteriaBuilder.count(root.get("balance")));
		//criteraQuery.select(root).where(criteriaBuilder.or(pre[0],pre[1]));
		
		criteraQuery.orderBy(criteriaBuilder.asc(root.get("name")), criteriaBuilder.desc(root.get("balance")));
		Query<Customer> query = session.createQuery(criteraQuery);
		query.setFirstResult(0);
		query.setMaxResults(3);
		List<Customer> customerList= query.list();
		System.out.println(customerList);
		
		session.close();
		
	}
	
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
