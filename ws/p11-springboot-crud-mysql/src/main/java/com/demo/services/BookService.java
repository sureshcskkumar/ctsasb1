package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;
import com.demo.utils.BookDatabase;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}
	public Book findBookById(int id) throws Exception {
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new Exception("Book with id: "+id+", is not found in database");
		}
	}
	public boolean deleteBookById(int id) {
		return false;
	}
	public Book editBoodById(int id, Book book) {
		Book updatedBook = null;
		book.setId(id);
		if(bookRepository.existsById(book.getId())) {
			// update
			updatedBook = bookRepository.save(book);
		} else {
			// do not save
		}
		
		return updatedBook;
	}
	
	public List<Book> filterBooks(double price){
		return bookRepository.findByPriceLessThan(price);
	}
}
