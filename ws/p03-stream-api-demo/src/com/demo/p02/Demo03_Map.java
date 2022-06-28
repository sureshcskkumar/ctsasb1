package com.demo.p02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee{
	private String name;
	private double salary;
	private int exp;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + ", exp=" + exp + "]";
	}
	public Employee(String name, double salary, int exp) {
		super();
		this.name = name;
		this.salary = salary;
		this.exp = exp;
	}
	public Employee() {
		super();
	}
	
}

public class Demo03_Map {
	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(
			new Employee("Mark", 1000, 2),
			new Employee("John", 5000, 5),
			new Employee("Carl", 1200, 3),
			new Employee("Tom", 1400, 4),
			new Employee("Brick", 1000, 1)
		);
		
		// to find all emps where exp is greater than 3
		// filter
		
		// to distribute bonus to all employees -> 5%
		// map
		emps.stream()
		.map((emp)->{
			emp.setSalary(emp.getSalary()*1.05);
			return emp;
		})
		.forEach((e)->System.out.println(e));
	}
}
