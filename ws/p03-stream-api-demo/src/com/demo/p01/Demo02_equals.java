package com.demo.p01;

class Employee{
	String name;
	Employee(String n){
		name = n;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}

public class Demo02_equals {
	public static void main(String[] args) {
		Employee emp1 = new Employee("KK");
		Employee emp2 = new Employee("KK");
		
		System.out.println("emp1==emp2 => "+(emp1==emp2));
		System.out.println("Emp1: "+emp1);
		System.out.println("Emp2: "+emp2);
		if(emp1.equals(emp2)) {
			System.out.println("Same");
		} else {
			System.out.println("Not same");
		}
	}
//	public static void main(String[] args) {
//		String emp1 = new String("KK");
//		String emp2 = new String("KK");
//		
//		System.out.println("emp1==emp2 => "+(emp1==emp2));
//		
//		System.out.println("Emp1: "+emp1);
//		System.out.println("Emp2: "+emp2);
//
//		if(emp1.equals(emp2)) {
//			System.out.println("Same");
//		} else {
//			System.out.println("Not same");
//		}
//	}
}
