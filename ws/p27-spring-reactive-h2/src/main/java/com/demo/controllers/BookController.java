package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Book;
import com.demo.services.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
//@CrossOrigin
@RequestMapping("/api/books")
public class BookController {

	@Autowired
    private BookService service;

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Book> getAll(){
        return service.getBooks();
    }

    @GetMapping(value="/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Book> getBook(@PathVariable int id){
        return service.getBook(id);
    }

    @PostMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Book> saveBook(@RequestBody Book book){
        return service.saveBook(book);
    }

    @PutMapping(value="/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        return service.updateBook(id, book);
    }

    @DeleteMapping(value="/{id}",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Book> deleteBook(@PathVariable int id){
        return service.deleteBook(id);
    }
    
    

}
