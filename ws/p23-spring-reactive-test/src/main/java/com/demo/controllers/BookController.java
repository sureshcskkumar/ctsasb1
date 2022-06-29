package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Book;
import com.demo.handlers.BookHandler;

import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "https://hoppscotch.io/")
public class BookController {

	@Autowired
	private BookHandler handler;
	
//	@PostMapping("/router/books")
//	public Mono<Book> saveBook(@RequestBody Mono<Book> monoBook){
//		return handler.saveBook(monoBook);
//	}
	
	@PostMapping("/router/books")
	public ResponseEntity<?> saveBook(@RequestBody Mono<Book> monoBook){
		return new ResponseEntity<Mono<Book>>(handler.saveBook(monoBook), HttpStatus.CREATED);
	}

}
