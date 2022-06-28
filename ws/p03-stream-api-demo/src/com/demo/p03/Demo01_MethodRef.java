package com.demo.p03;

import java.util.function.Function;

class BookDao{
	
	public String findBookById(int a) {
		// logic to find book from database
		System.out.println("Finding book from database where id = "+a);
		return "Book_"+a;
	}
}

public class Demo01_MethodRef {

	public static void main(String[] args) {
//		Function<Integer, String> func = (a)->"Book_"+a;
//		Function<Integer, String> func = BookDao::findBookById;
		Function<Integer, String> func = new BookDao()::findBookById;
		
		String book = func.apply(184);
		System.out.println(book);
	}
}
