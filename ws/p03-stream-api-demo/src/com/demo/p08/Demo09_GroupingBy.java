package com.demo.p08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Ball{
	private String color;
	public Ball(String c){color = c;}
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	@Override
	public String toString() {
		return "Ball [color=" + color + "]";
	}
	
}

public class Demo09_GroupingBy {
	public static void main(String[] args) {
		List<Ball> balls = Arrays.asList(
				new Ball("Green"), 
				new Ball("Black"), 
				new Ball("Green"), 
				new Ball("Red"), 
				new Ball("Black"), 
				new Ball("Red"), 
				new Ball("Red"), 
				new Ball("Green"), 
				new Ball("Red"), 
				new Ball("Black"), 
				new Ball("Red"), 
				new Ball("Black"), 
				new Ball("Green")
		);
//		balls
//		.stream()
//		.collect(Collectors.toList())
//		.forEach(System.out::println);
		
		Map<String, List<Ball>> map = balls
		.stream()
		.collect(Collectors.groupingBy(b->b.getColor()));
		
		System.out.println(map);
		
		map.entrySet().stream().forEach(System.out::println);
		
	}

}
