package com.brainmentors.apps;

import java.util.Arrays;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated().and().oauth2Login();
		/*
		ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry urlAuth = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().
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
		//.addFilterBefore(new VerifyTokenFilter(), BasicAuthenticationFilter.class)
		//.addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
		
		.authorizeRequests();
		urlAuth.antMatchers("/order").authenticated().and().oauth2Login();
		urlAuth.antMatchers("/payment").authenticated()
		.antMatchers("/contactus").permitAll()
		.antMatchers("/about").permitAll().and().formLogin().and().httpBasic();
		*/
	}
	
//	private ClientRegistration clientRegistration(){
//		return CommonOAuth2Provider.GITHUB.getBuilder("github")
//		.clientId("f1e6bf0e541cb9103e3f")
//		.clientSecret("779d38c07ad834232c54db2548d406adbfe725f1")
//		.scope(new String[] {"read:user"}).authorizationUri("https://github.com/login/oauth/authorize")
//		.tokenUri("https://github.com/login/oauth/access_token").userInfoUri("https://api.github.com/user")
//		.userNameAttributeName("id").clientName("GitHub")
//		.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//		.redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}").build();
//	}
	
//	builder.authorizationUri("https://github.com/login/oauth/authorize");
//	builder.tokenUri("https://github.com/login/oauth/access_token");
//	builder.userInfoUri("https://api.github.com/user")
//	
//	@Bean
//	public ClientRegistrationRepository clientRepository() {
//		ClientRegistration clientReg  = clientRegistration();
//		return new InMemoryClientRegistrationRepository(clientReg);
//	}
//	
	

}
