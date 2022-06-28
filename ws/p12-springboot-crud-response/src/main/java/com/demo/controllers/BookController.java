package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Book;
import com.demo.services.BookService;

//@Controller
//@ResponseBody

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
	@PostMapping("/books")
	public ResponseEntity<?> createBook(@RequestBody Book book) {
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}
	@GetMapping("/books")
	public List<Book> findAllBooks(){
		return bookService.findAllBooks();
	}
	@GetMapping("/books/{id}")
	public Book findBookById(@PathVariable int id) throws Exception {
		return bookService.findBookById(id);
	}
	@GetMapping("/books/filterBy/{price}")
	public List<Book> fliterBooks(@PathVariable double price) throws Exception {
		return bookService.filterBooks(price);
	}
	
	
	public boolean deleteBookById(int id) {
		return false;
	}
	@PutMapping("/books/{id}")
	public Book editBoodById(@PathVariable int id, @RequestBody Book book) {
		return bookService.editBoodById(id, book);
	}
	
}
