package com.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.entities.Book;

//interface MyRepo<T, K>{
//	public List<T> findAll();
//	public T findById(K id);
//	public T save(T t);
//}

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	public List<Book> findByTitle(String title);

//	@Query(value="SELECT * FROM BOOK where price > ?1", nativeQuery = false)
	@Query(value="select book from Book book where book.price > ?1", nativeQuery = false)
	public List<Book> findByPriceLessThan(double price);
}

