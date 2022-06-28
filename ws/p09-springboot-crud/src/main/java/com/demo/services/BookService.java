package com.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.demo.entities.Book;
import com.demo.utils.BookDatabase;

@Service
public class BookService {

	public Book createBook(Book book) {
		return BookDatabase.save(book);
	}
	public List<Book> findAllBooks(){
		return BookDatabase.findAll();
	}
	public Book findBookById(int id) {
		return BookDatabase.findById(id);
	}
	public boolean deleteBookById(int id) {
		return false;
	}
	public Book editBoodById(int id, @RequestBody Book book) {
		return null;
	}
}
