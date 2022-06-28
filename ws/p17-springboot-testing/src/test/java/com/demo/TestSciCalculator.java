package com.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.utils.Calculator;
import com.demo.utils.SciCalculator;

@SpringBootTest
public class TestSciCalculator {

	@Autowired
	private SciCalculator sCalc;
	@MockBean
    private Calculator calc;
	
	@Test
	public void shouldAdd2Numbers() {
		
		int a = 1;
		int b = 2;
		
		Mockito.when(calc.add(0, a)).thenReturn(a);
		Mockito.when(calc.add(a, b)).thenReturn(a+b);
		
		int actual = sCalc.addMulti(a,b);
		int expected = 3;
		
		Assertions.assertSame(expected, actual, "ErrorMessage: Expected: "+expected+", but getting: "+actual); 
	}

	@Test
	public void shouldAddMultipleNumbers() {
		
		Mockito.when(calc.add(0, 1)).thenReturn(1);
		Mockito.when(calc.add(1, 2)).thenReturn(3);
		Mockito.when(calc.add(3, 3)).thenReturn(6);
		Mockito.when(calc.add(6, 4)).thenReturn(10);
		Mockito.when(calc.add(10, 5)).thenReturn(15);
		Mockito.when(calc.add(15, 6)).thenReturn(21);
		
		int actual = sCalc.addMulti(1,2,3,4,5,6);
		int expected = 21;
		
		Assertions.assertSame(expected, actual, "ErrorMessage: Expected: "+expected+", but getting: "+actual); 
	}
	
}
