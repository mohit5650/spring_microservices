package com.brainmentors.apps.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.brainmentors.apps.models.Product;


//interface ProductQuery{
//	@Query("select p from Product")
//	List<Product> getAllProducts();
//}

@Repository
@Transactional
public class ProductDAO {//implements ProductQuery{
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	public List<Product> getAllProducts() {
		List<Product> products = entityManager.
				createQuery("select p from Product p", Product.class).getResultList();
		return products;
	}
	
		
	
	public long addProduct(Product product) {
		entityManager.persist(product);
		return product.getId();
	}
}
