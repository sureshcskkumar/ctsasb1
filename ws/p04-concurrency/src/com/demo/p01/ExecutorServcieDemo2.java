package com.demo.p01;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServcieDemo2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Runnable r = () -> {
			System.out.println("Thread name: " + Thread.currentThread().getName());
//			return "some text";
		};
		
		Callable<Integer> c = ()->{
//			Thread.sleep(5000);
			System.out.println("Thread in callable: "+Thread.currentThread().getName());
			String name = null;
			System.out.println(name.charAt(0));
			return (int)(Math.ceil(Math.random()*1000));
		};
		serviceExecute(c);
	}

	private static void serviceExecute(Callable<Integer> c) throws InterruptedException, ExecutionException {
		int cpus = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(cpus);
		
//		service.execute(c);
		try {
		Future<Integer> future = service.submit(c);
		
		System.out.println("In main");
		// wait -> 
		Integer res = future.get();

		System.out.println("Result: " + res);
	} catch(ExecutionException e) {
			System.out.println(e);
		}
	}
}
