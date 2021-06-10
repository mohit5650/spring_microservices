package com.brainmentors.apps.isademo.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Config {
	
	private static SessionFactory sessionFactory;
	
//	public static SessionFactory getSessionFactory(){
//		if(sessionFactory==null) {
//		sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//		}
//		return sessionFactory;
//	}
	
//	public static SessionFactory getSessionFactory() {
//		if(sessionFactory == null) {
//			Configuration configuration = new Configuration();
//			Properties props = new Properties();
//			props.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
//			props.put(Environment.URL,"jdbc:mysql://localhost:3306/relationaleg");
//			configuration.setProperties(props);
//			configuration.addAnnotatedClass(Customer.class);
//			sessionFactory=  configuration.buildSessionFactory();
//		}
//		return sessionFactory;
//	}
	
//	public static SessionFactory getSessionFactory() {
//		if(sessionFactory == null) {
//			sessionFactory = new AnnotationConfiguration().configure(new File("hibernate.cfg.xml")).buildSessionFactory();
//		}
//		return sessionFactory;
//	}
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			Metadata metaData = new MetadataSources(standardServiceRegistry).getMetadataBuilder().build();
			sessionFactory = metaData.getSessionFactoryBuilder().build();
			
		}
		return sessionFactory;
	}
	

	
	
	
	
	
	
	
	
	
}
