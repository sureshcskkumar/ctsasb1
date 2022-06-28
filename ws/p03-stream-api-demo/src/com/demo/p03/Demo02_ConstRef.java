package com.demo.p03;

interface BookType{
//	void doTask();
	void doTask(String title);
}

class Book {
	private String book;

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

	public Book(String book) {
		super();
		this.book = book;
	}
	public Book() {
		super();
	}

}

public class Demo02_ConstRef {

	public static void main(String[] args) {
//		BookType obj1 = new Book();
//		BookType obj2 = new Book("My Book");
		
		BookType obj3 = Book::new;
	}
}
