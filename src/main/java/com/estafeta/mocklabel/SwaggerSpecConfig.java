package com.estafeta.mocklabel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Configuration
public class SwaggerSpecConfig {

	@Primary
	@Bean
	public SwaggerResourcesProvider swaggerResourcesProvider(
			InMemorySwaggerResourcesProvider defaultResourcesProvider) {
		return () -> {
			SwaggerResource wsResource = new SwaggerResource();
			wsResource.setName("Estafeta Label Mock");
			wsResource.setSwaggerVersion("2.0");
			wsResource.setLocation("/swagger.json");

			List<SwaggerResource> resources = new ArrayList<>(defaultResourcesProvider.get());
			resources.add(wsResource);
			return resources;
		};
	}

}
