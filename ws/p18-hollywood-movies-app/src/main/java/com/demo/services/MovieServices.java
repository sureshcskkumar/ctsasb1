package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Movie;
import com.demo.repositories.MovieRepository;

@Service
public class MovieServices {

	@Autowired
	private MovieRepository repo;
	
	public List<Movie> getAll(){
		return repo.findAll();
	}
	
	public Movie saveMovie(Movie m) {
		return repo.save(m);
	}
	
}
