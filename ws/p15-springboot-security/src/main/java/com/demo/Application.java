package com.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
//@ComponentScan({"demo.com", "com.demo"})
public class Application implements CommandLineRunner {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("My app got started...");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
