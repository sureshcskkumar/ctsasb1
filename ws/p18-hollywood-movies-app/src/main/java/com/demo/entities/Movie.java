package com.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private double rating;
	private String director;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", rating=" + rating + ", director=" + director + "]";
	}
	public Movie() {
		super();
	}
	public Movie(String title, double rating, String director) {
		super();
		this.title = title;
		this.rating = rating;
		this.director = director;
	}
	public Movie(int id, String title, double rating, String director) {
		this(title, rating, director);
		this.id = id;
	}
	
}
