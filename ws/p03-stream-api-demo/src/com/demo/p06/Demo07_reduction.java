package com.demo.p06;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Demo07_reduction {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5,8,7);

//		// way 1
//		Optional<Integer> optional = list.stream().reduce((x,y)->x+y);
//		Integer num = optional.orElse(0);
//		System.out.println(num);
//		
//		// way 2
//		Integer num2 = list.stream().reduce(15, (x,y)->x+y);
//		System.out.println(num2);

		// way 3
		Integer num3 = list.parallelStream().reduce(5, (x,y)->{
//			System.out.println("in combiner, X: "+x+", Y: "+y);
			return x+y;
		}, (a,b)->{
//			System.out.println("in combiner, A: "+a+", B: "+b);
			return a+b;
		});
		
// 5+5+ 5+8+ 5+7 = 35
		System.out.println(num3);
	}
	
}
