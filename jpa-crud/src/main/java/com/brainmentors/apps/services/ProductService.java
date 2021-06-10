package com.brainmentors.apps.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brainmentors.apps.helpers.ProductHelper;
import com.brainmentors.apps.models.Product;

@Service
public class ProductService {
	@Autowired
	private ProductHelper productHelper;
	public List<Product> getAllProducts() {
		return productHelper.getAllProducts();
	}
	
	public String addProduct(Product product) {
		return productHelper.addProduct(product)!=0?"Product Added":"Product Not Added";
	}

}
