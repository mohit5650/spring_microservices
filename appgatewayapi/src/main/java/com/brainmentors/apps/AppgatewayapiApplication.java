package com.brainmentors.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableEurekaClient

public class AppgatewayapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppgatewayapiApplication.class, args);
	}

}
