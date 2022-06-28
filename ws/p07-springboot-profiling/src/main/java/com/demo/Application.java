package com.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Value("${db.host}")
	private String host;
	@Value("${db.username}")
	private String username;
	@Value("${db.password}")
	private String pwd;
	@Value("${db.port}")
	private String port;
	@Value("${common.key}")
	private String common;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("My app got started...");
		System.out.println("Db host: "+host);
		System.out.println("Db port: "+port);
		System.out.println("Db username: "+username);
		System.out.println("Db password: "+pwd);
		System.out.println("Common key: "+common);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
}
