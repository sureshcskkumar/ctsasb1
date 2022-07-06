package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.models.Book;

@Component
public class DummyDb {
	private List<Book> books = new ArrayList<Book>();
	
	public DummyDb() {
		books.add(new Book(145, "superman", "mark", 45));
		books.add(new Book(171, "batman", "miley", 12));
		books.add(new Book(24, "shaktiman", "mukesh", 99));
		books.add(new Book(55, "hanuman", "shiva", 999));
		books.add(new Book(196, "hulk", "carl", 107));
	}
	
	public List<Book> getBooks() {
		return new ArrayList<Book>(books);
	}
}
