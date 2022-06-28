package com.demo.p03;

import java.time.LocalDate;

interface MovieCreator{
	public Movie createMovie(String title, String director, double rating, LocalDate releasedDate);
}

class Movie{
	private String title;
	private String director;
	private double rating;
	
	public Movie(String title, String director, double rating, LocalDate releasedDate) {
		super();
		this.title = title;
		this.director = director;
		this.rating = rating;
		this.releasedDate = releasedDate;
		
		System.out.println("in const");
	}

	
	private LocalDate releasedDate;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public LocalDate getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
	@Override
	public String toString() {
		return "Movie [title=" + title + ", director=" + director + ", rating=" + rating + ", releasedDate="
				+ releasedDate + "]";
	}
}

public class Demo03_ConstRef {

	public static void main(String[] args) {
		MovieCreator movieCreator = Movie::new;
		MovieCreator movieCreator1 = (t, d, r, reDate)->new Movie(t, d, r, reDate);
		
		Movie movie = movieCreator.createMovie("Superman is flying", "Carl", 4.9, LocalDate.of(2017, 1, 15));
		System.out.println(movie);
	}
}
