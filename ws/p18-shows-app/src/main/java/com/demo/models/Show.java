package com.demo.models;

public class Show {

	private int id;
	private String title;
	private double rating;
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
	@Override
	public String toString() {
		return "Show [id=" + id + ", title=" + title + ", rating=" + rating + "]";
	}
	
	
	
}
