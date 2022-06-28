package com.demo.p03;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		Map<String, String> map = new HashMap<>();
		
		StampedLock lock = new StampedLock();
		
		Runnable readTask = ()->{
			long stamp = lock.readLock();
			try {
				Thread.sleep(400);
			System.out.println(Thread.currentThread().getName()+" is reading time: "+map.get("now"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlockRead(stamp);
			}
		};
		Runnable writeTask = ()->{
			long stamp = lock.writeLock();
			try {
				Thread.sleep(100);
			System.out.println(Thread.currentThread().getName()+" is updating time");
			map.put("now", LocalDateTime.now().toString());
			} catch (InterruptedException e) {
				System.out.println(e);
			} finally {
				lock.unlockWrite(stamp);
			}
		};
		
		
		for(int i=0;i<100;i++) {
			executor.submit(readTask);
			executor.submit(writeTask);
		}
	}
	
}
