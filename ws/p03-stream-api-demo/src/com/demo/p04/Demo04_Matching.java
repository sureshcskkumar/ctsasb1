package com.demo.p04;

import java.util.ArrayList;
import java.util.List;

class Customer{
	private String name;
	private int age;
	private String gender;
	private boolean active = true;
	
	public Customer() {}
	
	public Customer(String name, int age, String gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean isActive() {
		return active;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", gender=" + gender + ", active=" + active + "]";
	}
}

public class Demo04_Matching {

	public static void main(String[] args) {
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer("Miley Cyrus", 29, "F"));
		customers.add(new Customer("Tom Carl", 25, "M"));
		customers.add(new Customer("Tom Brick", 29, "M"));
		customers.add(new Customer("John Cena", 31, "M"));
		customers.add(new Customer("Ram Kapoor", 24, "M"));
		customers.add(new Customer("Shyamli Kapoor", 28, "F"));

	long count = customers.stream().filter((cus)->"F".equals(cus.getGender())).count();
	System.out.println("Females count: "+count);
	
	boolean foundFemaleAnyWhere = customers.stream().anyMatch((cus)->"F".equals(cus.getGender()));
	System.out.println(foundFemaleAnyWhere);
	
	boolean matchingAllAges = customers.stream().allMatch((cus)->cus.getAge()>20);
	System.out.println(matchingAllAges);
	
	boolean matchingNoneAge = customers.stream().noneMatch((cus)->cus.getAge()>80);
	System.out.println(matchingNoneAge);
	
	
	
	// find/check customer with name Kapoor --> 
	
	// find
	customers
		.stream()
		.filter((cus)->cus.getName().contains("Kapoor"))
		.forEach(System.out::println);
	
	}
	
}
