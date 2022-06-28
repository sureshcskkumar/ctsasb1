package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController // = @Controller + @ResponseBody
@Controller
public class DemoController {

	@ResponseBody
	@GetMapping("/greet")
	public String greet() {
		return "welcome";
	}
	
	@GetMapping("/welcome")
	public String helloPage() {
		return "hello";
	}
	
	// GET -> 405
	@PostMapping("/doTask")
	public String doTask() {
		return "hello";
	}
	
	// 500
	@GetMapping("/greet/{username}")
	@ResponseBody
	public String greetUser(@PathVariable String username) {
		username = null;
		username = (username.charAt(0)+"").toUpperCase() + username.substring(1).toLowerCase();
		
		return "Welcome "+username;
	}
	
//	404 -> /sayhello
}
