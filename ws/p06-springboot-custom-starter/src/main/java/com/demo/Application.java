package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

//	@Autowired
//	private MessageConverter converter;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		System.out.println(converter.translate("My app got started..."));
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
