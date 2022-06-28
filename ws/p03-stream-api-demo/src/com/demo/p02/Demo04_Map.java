package com.demo.p02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Demo04_Map {
	public static void main(String[] args) {
		List<Employee> emps = Arrays.asList(
			new Employee("Mark", 1000, 2),
			new Employee("John", 5000, 5),
			new Employee("Carl", 1200, 3),
			new Employee("Tom", 1400, 4),
			new Employee("Brick", 1000, 1)
		);

		List<Employee> list1 = emps.stream()
		.map((emp)->{
			emp.setSalary(emp.getSalary()*1.05);
			return emp;
		})
		.collect(Collectors.toList());

		List<Double> list2 = emps.stream()
		.map((emp)->{
			emp.setSalary(emp.getSalary()*1.05);
			return emp.getSalary();
		})
		.collect(Collectors.toList());

		List<String> list3 = emps.stream()
		.map((emp)->{
			emp.setSalary(emp.getSalary()*1.05);
			return emp.getName();
		})
		.collect(Collectors.toList());

	}
}
