package com.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowsController {
	@GetMapping("/find")
	public List<String> allMovies(){
		return Arrays.asList("Superman", "Batman", "Hulk");
	}
	
}
