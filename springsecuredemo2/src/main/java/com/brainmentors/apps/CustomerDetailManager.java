package com.brainmentors.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailManager implements UserDetailsManager {
	
	public CustomerDetailManager() {
		System.out.println("CustomerDetailManager Cons call...");
	}
	@Autowired
	private CustomerUserDetailService customerUserDetailService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("Inside CustomerDetailManager loadUserByUsername ::"+username);
		
		
		return customerUserDetailService.loadUserByUsername(username);
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}

}
