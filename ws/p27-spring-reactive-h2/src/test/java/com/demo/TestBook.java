package com.demo;

import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.startsWith;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import com.demo.entities.Book;

@SpringBootTest(
		classes = Application.class,
		  webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class TestBook {

	private WebTestClient client;
	
	@Autowired
	private ApplicationContext context;
		
	@BeforeEach
	  public void setApplicationContext() {
	    this.client
	      = WebTestClient
	        .bindToApplicationContext(context)
	        .configureClient()
	        .baseUrl("/api/books")
	        .build();
	  }
	
	@Test
	public void testClient() {
		Assertions.assertNotNull(client);
	}
	
	@Test
	public void  shouldFindBooks() {
		this.client
			.get()
			.uri("")
			.accept(MediaType.TEXT_EVENT_STREAM)
			.exchange()
			.expectStatus()
			.isOk()
			.returnResult(Book.class)
			;
	}
	
	@Test
	public void  shouldSaveBooks() {
		this.client
			.post()
			.uri("")
			.body(BodyInserters.fromValue(new Book("Rain in Brain", "John", 22.2)))
			.accept(MediaType.TEXT_EVENT_STREAM)
			.exchange()
			.expectStatus()
			.isOk()
//			.returnResult(Book.class)
			.expectBody()
			.jsonPath("$").isNotEmpty()
//			.jsonPath("$.author").isEqualTo("John")
			;
	}

}
