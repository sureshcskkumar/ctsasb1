package com.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import com.demo.models.Book;

@RestController
@RequestMapping("kafka")
@CrossOrigin
public class BookController {

	@Autowired
    private KafkaTemplate<String, Book> kafkaTemplate;
	
	private static final String TOPIC = "kafka-topic";

    @GetMapping("publish")
    public String publishBook() {

        int id = (int)(Math.floor(Math.random()*100));
        kafkaTemplate.send(TOPIC, new Book(id, "Java Microservices", "Mark Carl", (((id*10)/3)-20)*2));

        return "Published successfully: "+LocalDateTime.now();
    }

    @GetMapping("publish/{title}/{price}")
    public String publishBook(@PathVariable String title, @PathVariable int price) {

        int id = (int)(Math.floor(Math.random()*100));
        kafkaTemplate.send(TOPIC, new Book(id, title, "Mark Carl", price));

        return "Published successfully";
    }
   

}
