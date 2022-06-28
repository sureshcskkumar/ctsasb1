package com.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.User;

@RestController
public class GreetController {

	@GetMapping("/greet")
	public String greetUser() {
		return "Hello";
	}
	
	@GetMapping("/greet/{uname}")
	public String greetUser(@PathVariable String uname) {
		return "Hello "+uname;
	}
	
	@GetMapping(value="/friends", produces = {
			MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE
		})
	public List<User> getAllFriends(){
		System.out.println("in getAllFriends");
		return Arrays.asList(
				new User("Miley", "123"),
				new User("John", "5874"),
				new User("Kelvin", "74589"),
				new User("Rajat", "52158")
		);
	}
	
}
