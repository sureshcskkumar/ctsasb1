package com.demo.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.entities.Book;

//@Repository
public interface BookRepository extends ReactiveMongoRepository<Book, Integer> {

}
