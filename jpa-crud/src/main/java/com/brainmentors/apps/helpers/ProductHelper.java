package com.brainmentors.apps.helpers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.brainmentors.apps.dao.ProductDAO;
import com.brainmentors.apps.models.Product;

@Component
public class ProductHelper {
	@Autowired
	private ProductDAO productDAO;
	public List<Product> getAllProducts() {
		return productDAO.getAllProducts();
	}
	
	public long addProduct(Product product) {
		return productDAO.addProduct(product);
	}
}
