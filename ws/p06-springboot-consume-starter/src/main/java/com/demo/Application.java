package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.api.JapaneseConverter;
import com.demo.api.MessageConverter;

@SpringBootApplication
//@ComponentScan({"demo.com", "com.demo"})
public class Application implements CommandLineRunner {

	@Autowired
	private MessageConverter converter;
	@Autowired
	private JapaneseConverter jConverter;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println(converter.translate("My app got started..."));
		System.out.println(jConverter.translate("My app got started..."));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
