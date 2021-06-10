package com.brainmentors.apps;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomerDetails  implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	
	
	public CustomerDetails(Customer customer) {
			this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority(customer.getRole()));
		return authList;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
