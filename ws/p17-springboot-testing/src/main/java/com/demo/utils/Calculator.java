package com.demo.utils;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
	public int add(int a, int b) {
		System.out.println("add method in calc");
		return a + b + b;
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mul(int a, int b) {
		return a * b;
	}
	
	public int div(int a, int b) {
//		if(b==0) {
//			throw new MyException("...");
//		}
		return a / b;
	}
	
	
}
