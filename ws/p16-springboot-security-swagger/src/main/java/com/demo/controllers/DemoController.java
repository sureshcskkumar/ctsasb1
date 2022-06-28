package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Hello user";
	}
	@GetMapping("/greet")
	public String greet() {
		return "Welcome user";
	}
	
	@GetMapping("/greet/{name}")
	public String greet(@PathVariable String name) {
		return "Welcome "+name;
	}
	
}
