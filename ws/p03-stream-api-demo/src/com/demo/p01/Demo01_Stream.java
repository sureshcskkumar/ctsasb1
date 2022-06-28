package com.demo.p01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo01_Stream {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3,6,1,33,25,91);
		
//		List<Integer> evenNums = new ArrayList<Integer>();
		// without stream
//		for(int n:list) {
//			if(n%2==0) {
//				evenNums.add(n);
//			}
//		}
//		System.out.println(evenNums);
		
		
		// with stream
//		Stream<Integer> stream = list.stream();
//		Stream<Integer> stream2 = stream.filter((n)->n%2==0);
//		List<Integer> filteredList = stream2.collect(Collectors.toList());
//		System.out.println(filteredList);
	
		
		List<Integer> filteredList = 
				list
					.stream()
					.filter((n)->n%2==0)
					.collect(Collectors.toList());
		
		System.out.println(filteredList);


	}
}
