package com.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.controllers.BookController;
import com.demo.entities.Book;
import com.demo.handlers.BookHandler;

import reactor.core.publisher.Mono;

@WebFluxTest//(BookController.class)
public class TestBookController {

//	@Autowired
//	private BookController controller;

	@Autowired
	private WebTestClient client;
	
	@MockBean
	private BookHandler handler;
	
//	@Autowired
//	private  MockMvc mockMvc;
	
	@Test
	public void shouldSaveBookWithoutMocking() {
		client
			.post()
			.uri("/router/books")
			.body(Mono.just(new Book(148, "Superman", "Batman", 24)), Book.class)
			.exchange()
			.expectStatus().isCreated();
	}
	
	@Test
	public void shouldSaveBookWithMocking() {
		Mono<Book> monoBook = Mono.just(new Book("Superman", "Batman", 24));
		Mockito.when(handler.saveBook(monoBook)).thenReturn(Mono.just(new Book(148, "Superman", "Batman", 24)));
		client
			.post()
			.uri("/router/books")
			.body(monoBook, Book.class)
			.exchange()
			.expectStatus().isCreated();
		
//		Mockito.verify(handler, Mockito.times(1)).saveBook(monoBook);
	}
	
//	@Test
//	public void shouldGetAllBooks() throws Exception {
//		mockMvc.perform(MockMvcRequestBuilders.get("/router/books"))
//	     .andExpect(MockMvcResultMatchers.status().isOk())
//	     .andExpect(MockMvcResultMatchers.content().contentType(MediaType.TEXT_EVENT_STREAM));
//	}
	
}
