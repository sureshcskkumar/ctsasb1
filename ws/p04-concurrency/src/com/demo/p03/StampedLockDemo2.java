package com.demo.p03;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo2 {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newFixedThreadPool(1);
//		List<String> list = new ArrayList<>();
		List<String> list = Arrays.asList("Superman", "Hulk", "Batman", "Ironman", "Antman", "Spiderman");
		StampedLock lock = new StampedLock();
		
		Runnable readTask = ()->{
//			long stamp = lock.readLock();
			try {
			for(int i=0;i<list.size();i++) {
				System.out.println(Thread.currentThread().getName()+": "+list.get(i));
			}
			} finally {
//				lock.unlockRead(stamp);
			}
		};
		Runnable writeTask = ()->{
//			long stamp = lock.writeLock();
			try {
			System.out.print(Thread.currentThread().getName());
//			for(int i=0;i<list.size();i++) {
//				if(!list.get(i).endsWith("man")) {
//					String removedStr = list.remove(i);
//					System.out.println(removedStr);
//				}
//			}
			
			int index = 0;
			for(String hero: list) {
				
				if(hero.endsWith("man")) {
					System.out.println(", Do not remove");
				} else {
					System.out.println(", Removing: "+hero);
					list.remove(index);
				}
				index++;
			}
			} finally {
//				lock.unlockWrite(stamp);
			}
		};
		
		
		for(int i=0;i<100;i++) {
			executor.submit(readTask);
			executor.submit(writeTask);
		}
	}
	
}
