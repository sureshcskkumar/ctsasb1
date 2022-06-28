package com.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
