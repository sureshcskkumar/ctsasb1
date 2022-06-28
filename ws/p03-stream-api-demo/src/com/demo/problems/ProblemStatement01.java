package com.demo.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Find all students who lives in a given city
*/

class Student{
	private String name;
	private int roll;
	private String city;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", roll=" + roll + ", city=" + city + "]";
	}
	public Student(String name, int roll, String city) {
		super();
		this.name = name;
		this.roll = roll;
		this.city = city;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}


public class ProblemStatement01 {

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Mark", 152, "delhi"));
		students.add(new Student("John", 21, "bangalore"));
		students.add(new Student("Miley", 31, "delhi"));
		students.add(new Student("Rajat", 27, "chennai"));
		students.add(new Student("Manu", 341, "pune"));
		students.add(new Student("Megha", 219, "delhi"));
		students.add(new Student("Suresh", 75, "pune"));
		students.add(new Student("Deepa", 46, "chennai"));
		students.add(new Student("Vinayak", 24, "bangalore"));
		students.add(new Student("Carl", 2, "bangalore"));
		
		System.out.println("Delhi");
		students
		.stream()
		.filter((std)->"delhi".equals(std.getCity()))
		.collect(Collectors.toList())
		.forEach(std->System.out.println(std));
	
		System.out.println("Bangalore");
		long bangaloreStdCount = students
		.stream()
		.filter((std)->"bangalore".equals(std.getCity()))
		.count();
		System.out.println(bangaloreStdCount);
		
		System.out.println("Pune");
		List<Student> puneStd = students
		.stream()
		.filter((std)->"pune".equals(std.getCity()))
		.collect(Collectors.toList());
		
		System.out.println(puneStd.size());
	}
	
	static void findStudentsByCity(String city, List<Student> students) {
		//
	}
	
}
