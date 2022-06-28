package com.demo;

import java.util.function.Consumer;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Working...");
//		monoDemo();
		fluxDemo();
	}
	
	private void fluxDemo() {
		Flux<?> fluxBooks = Flux
				.just(
					"Superman is flying again",
					"Ironman", 
					"Batman",
					"Antman",
					"Spiderman"
				)
				.concatWithValues("Hulk")
				.concatWith(Flux.error(new RuntimeException("My demo exception")))
				.log();
//		Consumer<String> c;
		fluxBooks.subscribe(
				(input)->{System.out.println("Input: "+input);},
				(e)->{System.out.println("Error: "+e.getMessage());}
		);

	}

	private void monoDemo() {
		Mono<?> monoBook = Mono
				.just("Superman is flying again")
				.then(Mono.error(new RuntimeException("My demo exception")))
				.log();
//		Consumer<String> c;
		monoBook.subscribe(
				(input)->{System.out.println("Input: "+input);},
				(e)->{System.out.println("Error: "+e.getMessage());}
		);
	}

}
