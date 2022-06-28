package com.demo.basic;

// SAM
@FunctionalInterface
interface Greeting {

	String greet(String name);
	String toString();
//	void show();
	
}

class GreetingImpl implements Greeting {
	
	@Override
	public String greet(String name) {
		return "Welcome "+name;
	}
}

public class D1_Test1_Greeting {
	static void greetUser(Greeting greeting, String name){
		String result = greeting.greet(name);
		System.out.println(result);
	}

	public static void main(String[] args) {
		String name = "Arun";

//		 Way 1
//		GreetingImpl greeting = new GreetingImpl();
		
//		 Way 2
//		Greeting greeting = new GreetingImpl();
		
//		 Way 3
//		Greeting greeting = new Greeting() {
//			public String greet(String name) {
//				return "Welcome "+name+", how are you ?";
//			}
//		};
		
//		 Way 4 - lambda
//		Greeting greeting = (username)-> {
//				return "Welcome "+username+", hope you are good ?";
//		};		
		
//		 Way 5 - lambda
//		Greeting greeting = (username)-> "Welcome "+username+", hope you are good ?";
//		
//		greetUser(greeting, name);

	
//		 Way 6 - lambda
		greetUser((username)-> "Welcome "+username+", hope you are good ?", name);

	}

}
