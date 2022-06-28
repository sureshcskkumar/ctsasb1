package com.demo.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

public class D4_Lambda2__Unary_Demo {
	public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3);

        List<Integer> result = math(list,
                x -> x * 2,
                x -> x + 1);

        System.out.println(result); // [3, 5, 7, 9, 11, 13, 15, 17, 19, 21]

    }

    public static <T> List<T> math(List<T> list,
                                   UnaryOperator<T> uo, UnaryOperator<T> uo2) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            result.add(uo.andThen(uo2).apply(t));
//        	System.out.println(uo.andThen(uo2).apply(t));
        }
        return result;
    }
}
