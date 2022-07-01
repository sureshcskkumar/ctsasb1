package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.entities.Book;
import com.demo.repsitories.BookRepository;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	private BookRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		Flux<Book> fluxAll = repo.findAll();
		fluxAll.subscribe((book)->{
			System.out.println(book);
		});
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
