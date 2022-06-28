package com.demo.basic;

@FunctionalInterface
interface GreetUser {
	String greet(String name);
	/* 
		1. method return type
		2. method arg types
	*/
}

@FunctionalInterface
interface MyDemo {
	String doTask(String name);
}


public class D2_Test2_FunctionalInterface {
	static void greetUser(MyDemo greetUser, String name){
		String result = greetUser.doTask(name);
		System.out.println(result);
	}

	public static void main(String[] args) {
		String name = "Arun";
		
		MyDemo greetUser = (username)-> "Welcome "+username+", hope you are good ?";
		
		greetUser(greetUser, name);
	}

}
