package com.demo.p05;

import java.util.Optional;

class Student{
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

	public Student(String name) {
		super();
		this.name = name;
	}
	public Student() {
		super();
	}
	
}

class StudentService{
	private StudentDao dao = new StudentDao();

	public Optional<Student> findByName(String name) {
		if(validate(name)) {
			return dao.findStudentFromDatabaseByName(name);
		} else {
			return Optional.ofNullable(null);
		}
	}
	
	private boolean validate(String str) {
		if(str==null) {
			return false;
		} else if(str.trim().length()==0) {
			return false;
		}  else {
			return true;
		}
	}
}

class StudentDao{
	public Optional<Student> findStudentFromDatabaseByName(String name) {
		// logic to find object from database
		if(name.length()<4) {
			return Optional.ofNullable(null);
		} else {
			return Optional.of(new Student(name));
		}
	}
}

public class Demo06_Optional {
	public static void main(String[] args) throws Exception {
		StudentService service = new StudentService();
		
		String stdName = "ram";
		Optional<Student> optional = service.findByName(stdName);
		
//		System.out.println(optional.orElse(new Student("Superman")));
		if(optional.isEmpty()) {
//			throw new Exception("Student not found");
			System.out.println("Student not found");
		} else {
			System.out.println(optional.get());
		}
	}
}
