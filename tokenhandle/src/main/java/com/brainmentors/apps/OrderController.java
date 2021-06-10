package com.brainmentors.apps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
	@GetMapping("/order")
	public String orderDetails() {
		return "Order No - 1001";
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
