package com.brainmentors.apps.firstspringbootappdemo;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyWebService {
	
	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello Spring Boot";
	}	
	@RequestMapping(method=RequestMethod.GET , value = "/customers/{balance}")
	public List<Customer> getCustomers(@PathVariable double balance){
		System.out.println("Balance is "+balance);
		return Arrays.asList(new Customer(1001,"Ram",23333), new Customer(1002, "Shyam",45454), new Customer(1003, "Tim",544343));
		
	}

}
