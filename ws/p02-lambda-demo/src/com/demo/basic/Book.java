package com.demo.basic;

import java.time.LocalDate;

public class Book{
	private int id;
	private String title;
	private int price;
	private String author;
	private LocalDate releasedDate;

	public Book() {}
	public Book(String title, int price, String author, LocalDate releasedDate) {
		super();
		this.title = title;
		this.price = price;
		this.author = author;
		this.releasedDate = releasedDate;
	}
	public Book(int id, String title, int price, String author, LocalDate releasedDate) {
		this(title, price, author, releasedDate);
		this.id = id;
	}

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public LocalDate getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", price=" + price + ", author=" + author + ", releasedDate="
				+ releasedDate + "]";
	}
	
}
