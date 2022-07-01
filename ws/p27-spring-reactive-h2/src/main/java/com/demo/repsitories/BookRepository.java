package com.demo.repsitories;

import org.springframework.data.repository.reactive.ReactiveSortingRepository;

import com.demo.entities.Book;

public interface BookRepository extends ReactiveSortingRepository<Book, Integer> {

}