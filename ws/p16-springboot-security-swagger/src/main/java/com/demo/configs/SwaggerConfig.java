//package com.demo.configs;
//
//import java.util.Arrays;
//import java.util.Collections;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ApiKey;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//@Configuration 
//public class SwaggerConfig {
//
//	private ApiKey apiKey() { 
//	    return new ApiKey("JWT", "Authorization", "header"); 
//	}
//	
////	@Bean
////	public Docket api() {
////	    return new Docket(DocumentationType.SWAGGER_2)
////	      .apiInfo(apiInfo())
////	      .securitySchemes(Arrays.asList(apiKey()))
////	      .select()
////	      .apis(RequestHandlerSelectors.any())
////	      .paths(PathSelectors.any())
////	      .build();
////	}
////	
////	private ApiInfo apiInfo() {
////	    return new ApiInfo(
////	      "My REST API",
////	      "Some custom description of API.",
////	      "1.0",
////	      "Terms of service",
////	      new Contact("Sallo Szrajbman", "www.baeldung.com", "salloszraj@gmail.com"),
////	      "License of API",
////	      "API license URL",
////	      Collections.emptyList());
////	}
//	
//	
//	
//}
