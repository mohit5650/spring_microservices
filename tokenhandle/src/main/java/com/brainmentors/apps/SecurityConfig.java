package com.brainmentors.apps;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
		cors().configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				// TODO Auto-generated method stub
				CorsConfiguration corsConfig = new CorsConfiguration();
				corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
				corsConfig.setAllowedMethods(Collections.singletonList("*"));
				corsConfig.setAllowCredentials(true);
				corsConfig.setAllowedHeaders(Collections.singletonList("*"));
				corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
				corsConfig.setMaxAge(3600L);
				return corsConfig;
			}
		}).and().csrf().disable()
		.addFilterBefore(new VerifyTokenFilter(), BasicAuthenticationFilter.class)
		.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		
		.authorizeRequests().antMatchers("/order").authenticated()
		.antMatchers("/payment").authenticated()
		.antMatchers("/contactus").permitAll()
		.antMatchers("/about").permitAll().and().formLogin().and().httpBasic();
	}

}
