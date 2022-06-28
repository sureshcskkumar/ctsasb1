package com.demo.p01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Book {
	private int id;
	private String title;
	private String author;
	private int price;
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Book(String title, String author, int price) {
		super();
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book(int id, String title, String author, int price) {
		this(title, author, price);
		this.id = id;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + id;
		result = prime * result + price;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (id != other.id)
			return false;
		if (price != other.price)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}

public class Demo02_Filter {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(159, "Spiderman", "Tom", 29));
		books.add(new Book(247, "Batman", "John", 35));
		books.add(new Book(132, "Ironman", "Miley", 41));
		books.add(new Book(247, "Batman", "John", 35));
		books.add(new Book(159, "Spiderman", "Tom", 29));
		
		books.add(new Book(101, "Spiderman-1", "Tom", 29));
		books.add(new Book(102, "Spiderman-2", "Tom", 24));
		books.add(new Book(103, "Spiderman-3", "Tom", 32));
		books.add(new Book(104, "Spiderman-4", "Tom", 40));
		books.add(new Book(105, "Spiderman-5", "Tom", 38));
		
		
		
		List<Book> newBookList = books.stream().filter((book)->book.getPrice()>30).collect(Collectors.toList());
//		System.out.println(newBookList);
		for(Book b:newBookList) {
			System.out.println(b);
		}

		System.out.println("++++++++++++++++++++++++");
		
		List<Book> newSortedList = 
				books.stream()
				.filter((book)->book.getPrice()>30)
				.distinct() // find equal objects
				.sorted((b1, b2)->b1.getId()-b2.getId())
//				.skip(3)
				.limit(1)// get only n element
				.collect(Collectors.toList());
		
		newSortedList.forEach((element)->System.out.println(element));
		
	}
}
