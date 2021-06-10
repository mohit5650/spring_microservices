package com.brainmentors.apps;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@GetMapping("/")
	//@GetMapping("/order")
	//public String orderDetails(OAuth2AuthenticationToken token) {
	public String orderDetails(@AuthenticationPrincipal OAuth2User token) {
		System.out.println(":::::: Token is "+token);
		if(token!=null) {
		return "Order No - 1001 "+token.getAttribute("name");
		}
		else {
			return "Order No - 1001 ";
		}
	}
	
	// http://localhost:8080/login/oauth2/code/google
	@GetMapping("/login/oauth2/code/google")
	public String orderDetails3(@AuthenticationPrincipal OAuth2User token) {
		System.out.println(":::::: Token is ::::: "+token);
		if(token!=null) {
		return "Order No - 1001 "+token.getAttribute("name");
		}
		else {
			return "Order No - 1001 ";
		}
	}
	
	@GetMapping("/order")
	//public String orderDetails(OAuth2AuthenticationToken token) {
	public String orderDetails2(@AuthenticationPrincipal OAuth2User token) {
		System.out.println(":::::: Token is "+token);
		if(token!=null) {
		return "Order No - 1001 "+token.getAttribute("name");
		}
		else {
			return "Order No - 1001 ";
		}
	}
	
	@GetMapping("/about")
	public String about() {
		return "Shop App";
	}
	
	
	@GetMapping("/payment")
	public String payment() {
		return "Payment Options";
	}
	
	
	@GetMapping("/contactus")
	public String contactUs() {
		return "Contact Us";
	}
}
