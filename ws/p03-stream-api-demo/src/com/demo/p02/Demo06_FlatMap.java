package com.demo.p02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Demo06_FlatMap {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("ARUN","KUMAR");
		
		// final output -> A, R, U, N, K,....
		
		List<String> list = names.stream()
		.map(str->str.split(""))
		.flatMap(arr->Arrays.stream(arr))
		.distinct()
		.sorted()
		.collect(Collectors.toList());
		
		System.out.println(list);
		System.out.println(list.size());
		
	}
}
