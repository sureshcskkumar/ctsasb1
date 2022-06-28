package com.demo.p01;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServcieDemo {

	public static void main(String[] args) {
		Runnable r = () -> {
			System.out.println("Thread name: " + Thread.currentThread().getName());
		};
//		threadStart(r);
		serviceExecute(r);
	}

	private static void threadStart(Runnable r) {
		for (int i = 0; i < 100; i++) {
			Thread t = new Thread(r);
			t.start();
		}
		System.out.println("This is main thread: " + Thread.currentThread().getName());
	}

	private static void serviceExecute(Runnable r) {
		int cpus = Runtime.getRuntime().availableProcessors();
		ExecutorService executor = Executors.newFixedThreadPool(cpus);

//		ExecutorService service = Executors.newCachedThreadPool();
//		ExecutorService service = Executors.newSingleThreadExecutor();
		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		
		for (int i = 0; i < 100; i++) {
//			service.execute(r);
			// fixed delay
//			service.schedule(r, 1000, TimeUnit.MILLISECONDS);
			// run again after n time
//			service.scheduleAtFixedRate(r, 2000, 2000, TimeUnit.MILLISECONDS);
			
			// fixed dalay
			service.scheduleWithFixedDelay(r, 2000, 2000, TimeUnit.MILLISECONDS);
			
			
		}
		System.out.println("This is main thread: " + Thread.currentThread().getName());
	}
}
