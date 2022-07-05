package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorityReactiveAuthorizationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class DemoConfig {

//	@Bean
//	public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//		http
//			.x509(Customizer.withDefaults())
//			.authorizeExchange(exchanges -> exchanges
//			    .anyExchange().permitAll()
//			);
//		return http.build();
//	}
	
	@Bean
	public SecurityWebFilterChain springWebFilterChain(ServerHttpSecurity http) {
		// @formatter:off
		http
//		.x509(Customizer.withDefaults())
			.authorizeExchange((authorize) -> authorize                          
				.pathMatchers("/resources/**", "/signup", "/about").permitAll()  
				.pathMatchers("/admin/**").hasRole("ADMIN")                      
				.pathMatchers("/db/**").access((authentication, context) ->      
				AuthorityReactiveAuthorizationManager.hasRole("ADMIN").check(authentication, context)
						.filter(decision -> !decision.isGranted())
						.switchIfEmpty(AuthorityReactiveAuthorizationManager.hasRole("DBA").check(authentication, context))
				)
				.anyExchange().denyAll()                                         
			);
		// @formatter:on
		return http.build();
	}
	
}
