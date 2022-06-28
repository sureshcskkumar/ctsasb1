package com.demo.basic;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D5_Lambda2_Comparator {

	public static void main(String[] args) {
		
//		List<Integer> nums = Arrays.asList(3, 6, 2, 99, 1, 6);
//		Collections.sort(nums);
//		System.out.println(nums);
		
		List<Book> books = Arrays.asList(
			new Book(459, "Superman", 37, "Miley", LocalDate.of(2012, 4, 16)),
			new Book(147, "Batman", 41, "John", LocalDate.of(2002, 9, 8)),
			new Book(249, "Ironman", 37, "Mark", LocalDate.of(2015, 1, 21)),
			new Book(341, "Spiderman", 39, "Carl", LocalDate.of(2017, 10, 28))
		);
		
//		Comparator<Book> comparator = new Comparator<Book>() {
//			public int compare(Book b1, Book b2) {
//				return b1.getTitle().compareTo(b2.getTitle());
//			}
//		};

		Comparator<Book> comparator = (b1, b2)-> {
			
			if(b1.getPrice()==b2.getPrice()) {
				return b1.getTitle().compareTo(b2.getTitle());
			} else {				
				return b1.getPrice()-b2.getPrice();
			}
			
		};
		
		Collections.sort(books, comparator);
		
		for(Book book:books) {
			System.out.println(book);
		}
	}
	
}
