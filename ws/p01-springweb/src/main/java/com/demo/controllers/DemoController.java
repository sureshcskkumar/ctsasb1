package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
@RequestMapping("/demo")
public class DemoController {

	// my first handler
	@GetMapping("/greet")
//	@ResponseBody
	public String greet() {
		System.out.println("In DemoController::greet...");
		return "login";
	}
	
}
