package com.demo.basic;

import java.util.function.BiConsumer;

//interface Addition{
//	void sum(int a, int b);
//}
//
//interface AddNumbers{
//	void add(int a, int b);
//}
//
//interface ConcateStr{
//	void concat(String str1, String str2);
//}
//
//interface StudentActivity{
//	void showStudentDetails(String studentClass, int studentRollNo);
//}
//
//interface MyCommon<T, R>{
//	void myTask(T t, R r);
//}


public class D3_Test3_FI {
	public static void main(String[] args) {
//		Addition addition = (a, b)-> System.out.print(a+b);
//		AddNumbers addNumbers = (a, b)-> System.out.print(a+b);
//		ConcateStr concateStr = (s1, s2)->System.out.println(s1+s2);
//		
//		MyCommon<Integer, Integer> common1 = (n1, n2)->System.out.println(n1+n2);
//		MyCommon<String, String> common3 = (s1, s2)->System.out.println(s1+s2);

		BiConsumer<String, String> biConsumer = (s1, s2)->System.out.println(s1+s2);
		
		biConsumer.accept("Java", "Lambda");
	}
}
