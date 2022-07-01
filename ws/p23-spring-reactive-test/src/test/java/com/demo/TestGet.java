package com.demo;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.demo.controllers.BookController;
import com.demo.entities.Book;
import com.demo.handlers.BookHandler;
import com.demo.repositories.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@WithMockUser
@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = BookController.class)
@Import(BookHandler.class)
public class TestGet {

	@MockBean
    BookRepository repository;

    @Autowired
    private WebTestClient client;
	
    
    @Test
    void getBooks() {
        Mockito
            .when(repository.findAll())
            .thenReturn(Flux.just(new Book(), new Book("title", "authro", 425)));

        client.get()
            .uri("/router/books")
            .accept(MediaType.TEXT_EVENT_STREAM)
            .exchange()
            .expectStatus().isOk();
    }
}
