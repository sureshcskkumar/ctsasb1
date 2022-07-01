package com.demo.services;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repsitories.BookRepository;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

    public Flux<Book> getBooks() {
        return repository
        		.findAll()
        		.delayElements(Duration.ofMillis(200))
//        		.map(book->book)
        		;
    }
    public Mono<Book> getBook(int id) {
        return repository.findById(id);
    }
    
    public Mono<Book> saveBook(Book book){
    	return repository.save(book);
    }
    
    public Mono<Book> updateBook(int id, Book book){
    	book.setId(id);
    	return repository.findById(book.getId())
    			.map(foundBook->book)
    	.flatMap(repository::save);
    }

    public Mono<Book> deleteBook(int id){
//    	return repository.deleteById(id);
    	return repository.findById(id)
    		      .doOnSuccess(book -> repository.delete(book).subscribe());
    }
}
