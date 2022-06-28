package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.daos.BookDao;
import com.demo.models.Book;

import reactor.core.publisher.Flux;

@Service
public class BookService {

	@Autowired
	private BookDao dao;
	
	public List<Book> getBooks(){
		return dao.getAllBooks();
	}

	public Flux<Book> getBooksAsync(){
		return dao.getAllBooksAsync();
	}
}
