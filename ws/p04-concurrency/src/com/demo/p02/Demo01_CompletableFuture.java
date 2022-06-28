package com.demo.p02;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo01_CompletableFuture {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Void result = runCode();
		System.out.println(result);

		List<String> list = getData();
		System.out.println(list);
	}
	
	private static Void runCode() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		CompletableFuture<Void> completableFuture = 
				CompletableFuture.runAsync(()->{
					System.out.println("Thread name: "+Thread.currentThread().getName());
					System.out.println("performing completable task");
				}, executor);
		
		return completableFuture.get();
	}

	private static List<String> getData() throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		CompletableFuture<List<String>> namesCompletableFuture = 
				CompletableFuture.supplyAsync(()->{
					System.out.println("Thread name: "+Thread.currentThread().getName());
					System.out.println("performing completable task");
					return Arrays.asList("Miley", "Carl", "John", "Tom", "Arun");
				}, executor);
		
		return namesCompletableFuture.get();
	}

}
