package com.demo.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.demo.entities.Book;

public class BookDatabase {

	private static int count = 1;
	private static Map<Integer, Book> books = new HashMap<Integer, Book>();
	
	public static Book save(Book book) {
		book.setId(count++);
		books.put(book.getId(), book);
		return book;
	}
	public static Book findById(int id) {
		return books.get(id);
	}
	public static List<Book> findAll() {
		List<Book> list = new ArrayList<Book>();
		Set<Entry<Integer,Book>> entrySet = books.entrySet();
		
		Iterator<Entry<Integer, Book>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<Integer, Book> next = iterator.next();
			Book b = next.getValue();
			list.add(b);
		}
		return list;
	}
	
}
