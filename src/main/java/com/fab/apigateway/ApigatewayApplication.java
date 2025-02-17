package com.fab.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApigatewayApplication {
////https://effortlesscodelearning.com/blog/how-to-implement-basic-authentication-with-spring-cloud-gateway/
	public static void main(String[] args) {
		SpringApplication.run(ApigatewayApplication.class, args);
	}
}
