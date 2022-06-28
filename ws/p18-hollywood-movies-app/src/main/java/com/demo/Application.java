package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Movie;
import com.demo.services.MovieServices;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private MovieServices service;
	
	@Override
	public void run(String... args) throws Exception {
		service.saveMovie(new Movie("Batman", 4.7, "Mark"));
		service.saveMovie(new Movie("Ironman", 4.4, "John"));
		service.saveMovie(new Movie("Spiderman", 4.8, "Miley"));
		service.saveMovie(new Movie("Hulk", 3.9, "Carl"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
