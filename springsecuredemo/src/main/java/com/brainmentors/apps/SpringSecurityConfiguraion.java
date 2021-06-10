package com.brainmentors.apps;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
@Configuration
public class SpringSecurityConfiguraion extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Inside Configure.......");
		//http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
		// Holiday Request + Mid Night Request
		//http.authorizeRequests().anyRequest().denyAll().and().formLogin().and().httpBasic();
		//http.authorizeRequests().anyRequest().permitAll().and().formLogin().and().httpBasic();
		http.authorizeRequests().antMatchers("/order").authenticated()
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
		return NoOpPasswordEncoder.getInstance();
	}
}
