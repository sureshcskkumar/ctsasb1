package com.demo.p02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo05_FlatMap {
	public static void main(String[] args) {
		List<Integer> primeNums = Arrays.asList(5, 7, 11, 13);
		List<Integer> oddNums = Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15);
		List<Integer> evenNums = Arrays.asList(2, 4, 6, 8, 10, 12, 14);
		
		List<List<Integer>> numsList = Arrays.asList(primeNums, oddNums, evenNums);
		System.out.println("Before flatmap: "+numsList);
	
		List<Integer> nums = numsList.stream().flatMap(list->list.stream())
				.distinct()
				.sorted()
		//convert this flatMap into list
		.collect(Collectors.toList());
		System.out.println("After flatmap: "+nums);
		
	}
}
