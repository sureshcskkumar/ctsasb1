package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.utils.Calculator;

@SpringBootTest
public class TestCalculator {

	@Test
	public void calculatorShouldSub() {
		Calculator calc = new Calculator();
		int actual = calc.sub(5, 4);
		int expected = 1;
		
		Assertions.assertEquals(expected, actual, "Sub method is not working");
	}
	
	@Test
	public void calculatorShouldNotDivByZero() {
		Calculator calc = new Calculator();
		
		Assertions.assertThrows(ArithmeticException.class, ()->{			
			calc.div(5, 0);
		});
	}
	
	
	
}
