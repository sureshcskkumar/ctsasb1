package com.demo;

import com.demo.repositories.CustomerDynamoDbRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

    @Autowired
    private CustomerDynamoDbRepository repo;

    @Override
    public void run(String... args) throws Exception {
        
//         C, U
         repo.putRecord();
        // C, U
         repo.putBatchRecords();
        // R
         repo.queryTableFilter();
        // R
//         repo.getAll();

        // D
        repo.deleteCust();
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApp.class, args);
    }
    
}