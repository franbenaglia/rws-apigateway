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
				.route("reactivehub", r -> r.path("/climateData/**").and().uri("lb://reactivehub"))
				.route("streaming", r -> r.path("/videos/stream/**").and().uri("lb://streaming"))
				.route("streamingnode", r -> r.path("/video/**").and().uri("lb://streamingnode"))
				.build();

	}

}
