package com.brainmentors.apps;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

public class VerifyTokenFilter  extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// get the token from the request header
		String jwtToken = request.getHeader(MySecurityConstants.JWT_TOKEN_HEADER);
		System.out.println("REQUEST TOKEN ################# "+jwtToken);
		try {
		if(jwtToken!=null) {
			// got the token from the request
			// get the secret key
			SecretKey key = Keys.hmacShaKeyFor(MySecurityConstants.JWT_SECRET_KEY.getBytes(StandardCharsets.UTF_8));
			Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();	
			String userName = claims.get(MySecurityConstants.USER_NAME).toString();
			String auth = claims.get(MySecurityConstants.AUTHORITIES).toString();
			Authentication authentication = new UsernamePasswordAuthenticationToken(userName, null,AuthorityUtils.commaSeparatedStringToAuthorityList(auth));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
		}
		catch(Exception e) {
			throw new BadCredentialsException("Invalid Token U Had Send");
		}
		filterChain.doFilter(request, response);
		
		 
	}
	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
	return request.getServletPath().equals("/order"); // register, login, home
}







}
