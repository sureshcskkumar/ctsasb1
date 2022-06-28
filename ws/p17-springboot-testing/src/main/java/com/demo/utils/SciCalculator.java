package com.demo.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SciCalculator {
	@Autowired
	private Calculator calc;
	
	public int addMulti(int ...nums) {
		int result = 0;
		for(int num:nums) {
//			result += num;
			result = calc.add(result, num);
			System.out.println("Result: "+result);
		}
		return result;
	}

}
