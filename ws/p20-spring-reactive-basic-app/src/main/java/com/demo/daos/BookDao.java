package com.demo.daos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.demo.models.Book;

import reactor.core.publisher.Flux;

@Component
public class BookDao {
	
	List<Book> books = null;
	
	public BookDao() {
		books = new ArrayList<Book>();
		for(int i=0;i<20;i++) {
			books.add(new Book(i, "Title_"+i, "Author_"+i, Math.random()*1000));
		}
	}

	public List<Book> getAllBooks(){
		return books
				.stream()
				.peek(book->{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				})
				.peek(book->{System.out.println("Inupt: "+book);})
				.collect(Collectors.toList());
	}
	
	public Flux<Book> getAllBooksAsync(){
		return Flux.fromStream(books.stream())
				.map(book-> {
					System.out.println("Getting book with id: "+book.getId());
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return book;
				});
		
	}

	
}
