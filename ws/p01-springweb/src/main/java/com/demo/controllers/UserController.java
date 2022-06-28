package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.models.User;

@Controller
@RequestMapping("/user")
public class UserController {

	// registration page
	@GetMapping("/registration")
	public String registrationPage() {
		return "user/registration";
	}
	
	// registration
	@PostMapping("/registration")
	public String handlerRegistration(@ModelAttribute User user) {
		System.out.println("in handlerRegistration");
		System.out.println(user);
		
		if(user.getUsername()!=null && user.getPwd()!=null) {
			return "user/signup-success";
		} else {
			return "user/registration";
		}
		
	}
	
}
