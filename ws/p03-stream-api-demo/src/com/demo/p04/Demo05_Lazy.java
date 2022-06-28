package com.demo.p04;

import java.util.ArrayList;
import java.util.List;

public class Demo05_Lazy {
	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Miley Cyrus", 29, "F"));
		customers.add(new Customer("Tom Carl", 25, "M"));
		customers.add(new Customer("Tom Brick", 29, "M"));
		customers.add(new Customer("John Cena", 31, "M"));
		customers.add(new Customer("Ram Kapoor", 24, "M"));
		customers.add(new Customer("Shyamli Kapoor", 28, "F"));

//		Customer customer1 = null;
//		for(int i=0;i<customers.size();i++) {
//			if(customers.get(i).getAge()>25) {
//				customers.get(i).setActive(false);
//				customer1 = customers.get(i);
//				System.out.println("in for loop: "+i);
//				break;
//			}
//		}
//		System.out.println(customer1);
		
		System.out.println("With stream api");
		
		Customer customer2 = 
				customers
				.stream()
				.filter((cus)->{
					System.out.println("In filter: "+cus);
					return cus.getAge()>25;
				})
				.map((cus)->{
					cus.setActive(false);
					System.out.println("In map: "+cus);
					return cus;
				})
//				.forEach(System.out::println);
				.findFirst()
				.orElseGet(Customer::new);
//		
		System.out.println("After findFirst: "+customer2);
		
		customers.forEach(System.out::println);
		
	}
}
