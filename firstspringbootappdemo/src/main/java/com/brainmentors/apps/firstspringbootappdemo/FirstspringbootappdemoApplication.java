package com.brainmentors.apps.firstspringbootappdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FirstspringbootappdemoApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(FirstspringbootappdemoApplication.class, args);
		for(String beanNames : appContext.getBeanDefinitionNames()) {
			System.out.println(beanNames);
		}
	}

}
