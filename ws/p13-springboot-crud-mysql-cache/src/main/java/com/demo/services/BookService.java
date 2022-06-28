package com.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;
import com.demo.utils.BookDatabase;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Cacheable(key="#id", value="book-store")
	public Book findBookById(int id) throws Exception {
		System.out.println("Finding by id: "+id);
		Optional<Book> optional = bookRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {
			throw new Exception("Book with id: "+id+", is not found in database");
		}
	}
	@CacheEvict(key="#id", value="book-store")
	public boolean deleteBookById(int id) {
		System.out.println("Deleting by id: "+id);
		if(bookRepository.existsById(id)) {
			bookRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	@CachePut(key="#id", value="book-store")
	public Book editBoodById(int id, Book book) throws Exception {
		System.out.println("Updating by id: "+id);
		Book updatedBook = null;
		book.setId(id);
		if(bookRepository.existsById(book.getId())) {
			// update
			updatedBook = bookRepository.save(book);
		} else {
			// do not save
			throw new Exception("Book with id: "+id+", is not found in database");
		}
		
		return updatedBook;
	}

	
	
	
	public List<Book> filterBooks(double price){
		return bookRepository.findByPriceLessThan(price);
	}
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}
	public List<Book> findAllBooks(){
		return bookRepository.findAll();
	}

	
}
