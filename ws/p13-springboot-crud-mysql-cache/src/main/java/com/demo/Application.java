package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Application implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("My app got started...");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
