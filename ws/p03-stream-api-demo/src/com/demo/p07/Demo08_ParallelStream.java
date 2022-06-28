package com.demo.p07;

import java.util.Arrays;
import java.util.List;

public class Demo08_ParallelStream {

	public static void main(String[] args) {
		List<String> names = Arrays.asList(
			"A","B","C","D","E","F","G","H", "I","J", "K", "L", "M", "N", "O", "P", "Q", "R"
		);
		
		long t1 = System.currentTimeMillis();
		names.stream().distinct().forEach(System.out::print);
		long t2 = System.currentTimeMillis();
		System.out.println("\nTotal time: "+(t2-t1));
		
		System.out.println("Parallel");
		
		t1 = System.currentTimeMillis();
		names.parallelStream().distinct().forEach(System.out::print);
		t2 = System.currentTimeMillis();
		System.out.println("\nTotal time: "+(t2-t1));
		
		
	}
	// LMFECHIGPRKJDOBNQA
	// LMCOKPJFNRDEBIGHAQ
	
}
