package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.Book;
import com.demo.services.BookService;

import reactor.core.publisher.Flux;

@RestController
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return service.getBooks();
	}
	
	@GetMapping(value="/books/async", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Book> getBooksAsync(){
		return service.getBooksAsync();
	}
	
}
