package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Movie;
import com.demo.services.MovieServices;

@RestController
@RequestMapping("/hollywood")
public class MovieController {

	@Autowired
	private MovieServices service;
	
	@GetMapping("")
	public List<Movie> allMovies(){
		return service.getAll();
	}
	
}
