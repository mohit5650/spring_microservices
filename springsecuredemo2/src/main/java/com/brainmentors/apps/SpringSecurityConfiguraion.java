package com.brainmentors.apps;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
@Configuration
public class SpringSecurityConfiguraion extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				// TODO Auto-generated method stub
				CorsConfiguration config = new CorsConfiguration();
				config.setMaxAge(86400L);
				config.setAllowCredentials(true);
				config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
				config.setAllowedMethods(Collections.singletonList("*"));
				config.setAllowedHeaders(Collections.singletonList("*"));
				return config;
			}
		}).and().csrf().ignoringAntMatchers("/contactus").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().
		//System.out.println("Inside Configure.......");
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
		// Holiday Request + Mid Night Request
		//http.authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();
		//http.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
		authorizeRequests().antMatchers("/order").authenticated()
		.antMatchers("/payment").authenticated()
		.antMatchers("/contactus").permitAll()
		.antMatchers("/about").permitAll().and().formLogin().and().httpBasic();
	}
	
//	@Bean
//	public UserDetailsService userDetailsService(DataSource dataSource){
//		return new JdbcUserDetailsManager(dataSource);
//	}
	
	/*@Override
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
		InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
		UserDetails firstUser = User.withUsername("amit").password("111111").authorities("admin").build();
		UserDetails secondUser = User.withUsername("ram").password("12345").authorities("read").build();
		inMemoryUserDetailsManager.createUser(firstUser);
		inMemoryUserDetailsManager.createUser(secondUser);
		authenticationManagerBuilder.userDetailsService(inMemoryUserDetailsManager);
		//		authenticationManagerBuilder.inMemoryAuthentication().withUser("amit").password("1234")
//		.authorities("admin").and().withUser("ram").password("12345").authorities("read").and()
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}*/
	
//	@Bean
//	public CustomerDetailManager getManager() {
//		return new CustomerDetailManager();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		//return NoOpPasswordEncoder.getInstance();
		return new BCryptPasswordEncoder();
	}
}
