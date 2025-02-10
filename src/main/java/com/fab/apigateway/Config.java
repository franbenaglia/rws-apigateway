package com.fab.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("task",
						r -> r.path("/api/task/**", "/auth/callback", "/auth/url", "/api/task/files/**").and()
								.method("GET", "POST", "PUT", "DELETE").uri("lb://task"))
				.route("security", r -> r.path("/auth/authenticate", "/userData/**").and().method("POST", "GET").and()
						.uri("lb://security"))
				.build();

//http://security	ok con post y get  (a veces falla por razones desconocidas, podria se eureka el responsable)
//http://task ok con todos los get task auth y files. post a api/task no funciona con jwt no se puede probar

	}

}
