package com.brainmentors.apps;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<Customer> customers = customerRepository.findByEmail(username);
		if(customers.size()==0) {
			throw new UsernameNotFoundException("User Name not found in DB "+username);
		}
		CustomerDetails customerDetails = new CustomerDetails(customers.get(0)); 
		System.out.println("User Found....");
		return customerDetails;
	}

}
