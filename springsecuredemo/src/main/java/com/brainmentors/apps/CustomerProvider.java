package com.brainmentors.apps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomerProvider implements AuthenticationProvider{
	@Autowired
	private CustomerDetailManager customerDetailManager;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		String userName = authentication.getName();
		System.out.println("REQ ::: "+userName + " " + authentication.getCredentials());
		String password = null;
		if(authentication.getCredentials()!=null) {
		password = authentication.getCredentials().toString();
		}
		UserDetails userDetails = customerDetailManager.loadUserByUsername(userName);
		if(userDetails==null) {
			throw new BadCredentialsException("User Not Match");
		}
		System.out.println("Create and return the token "+userName+" "+password);
		return new UsernamePasswordAuthenticationToken(userName, password);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
