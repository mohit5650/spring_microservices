package com.brainmentors.apps;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class JWTTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null) {
			// Signature 
			SecretKey key = Keys.hmacShaKeyFor(MySecurityConstants.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
			// Payload
			String jwtToken = Jwts.builder().setIssuer("Brain Mentors").setSubject("JWT Token")
			.claim(MySecurityConstants.USER_NAME, authentication.getName()) // user
			.claim(MySecurityConstants.AUTHORITIES, getAuthorities(authentication.getAuthorities())) // roles
			.setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime()+ 24 * 60 * 60 * 1000))
			.signWith(key).compact(); // add signature
			response.setHeader(MySecurityConstants.JWT_TOKEN_HEADER, jwtToken); // sending token in Authorization Header
			System.out.println("TOKEN ##################    "+jwtToken);
		}
		filterChain.doFilter(request, response);
		
	}
	
	String getAuthorities(Collection<? extends GrantedAuthority> authCollection) {
		Set<String> authSet = new HashSet<>();
		for(GrantedAuthority ga : authCollection) {
			String auth = ga.getAuthority();
			authSet.add(auth);
		}
		return String.join(",",authSet);
	}

}
