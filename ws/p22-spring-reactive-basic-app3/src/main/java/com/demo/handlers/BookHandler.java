package com.demo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookHandler {

	@Autowired
	private BookRepository repo;
	
	public Mono<ServerResponse> getBooks(ServerRequest req){
//		req.pathVariables()
		Flux<Book> books = repo.findAll();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(books, Book.class);
	}
	
	
	// consuming using controller
	public Mono<Book> saveBook(Mono<Book> monoBook){
		return monoBook.flatMap(repo::insert)
		.map(input->input);
	}
	
}
