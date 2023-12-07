package com.qtechlabs.vehiclemanagement.configuration;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select()
				.paths(postPaths()).build();
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/v1/vehicle.*"), regex("/api/v1/vehicle.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("VehicleManagement API")
				.description("API reference for VehicleManagement web application")
				.termsOfServiceUrl("https://qtechlabstac.com").contact("iamfarazjhs44@gmail.com")
				.license("Apache License").licenseUrl("iamfarazjhs44@gmail.com").version("1.0").build();
	}
}
