package com.demo.basic;

public class D6_Lambda2_Runnable {

	public static void main(String[] args) {
//		Runnable r = new Runnable() {
//			public void run() {
//				System.out.println("in runnable");
//			}
//		};
		Thread t1 = new Thread(()-> System.out.println("in runnable"));
		
		t1.start();
	}
	
}
