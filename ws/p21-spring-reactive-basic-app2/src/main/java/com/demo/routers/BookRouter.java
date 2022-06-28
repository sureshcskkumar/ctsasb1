package com.demo.routers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.handlers.BookHandler;

@Configuration
public class BookRouter {

	@Autowired
	private BookHandler handler;
	
	@Bean
	public RouterFunction<ServerResponse> myBookRouter(){
		return RouterFunctions.route()
				.GET("/router/books", handler::getBooks)
				.build();
	}
	
}
