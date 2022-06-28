package com.demo.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.demo.daos.BookDao;
import com.demo.models.Book;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookHandler {

	@Autowired
	private BookDao dao;
	
	public Mono<ServerResponse> getBooks(ServerRequest req){
//		req.pathVariables()
		Flux<Book> books = dao.getAllBooksAsync();
		return ServerResponse.ok()
				.contentType(MediaType.TEXT_EVENT_STREAM)
				.body(books, Book.class);
	}
	
}
