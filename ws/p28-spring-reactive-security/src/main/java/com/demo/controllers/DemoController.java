package com.demo.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class DemoController {

	@GetMapping(value="/greet", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Mono<String> greet(){
		return Mono.just("Welcome user");
	}
	
}
