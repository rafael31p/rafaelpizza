package com.rafael.pizzeria;

import java.util.List;

public class TestUtils {
    public static boolean isNarcissistic(int number) {
        String valor = String.valueOf(number);
        List<Character> valores = valor.chars().
                mapToObj(c -> (char) c).toList();
        List<Integer> values = valores.stream().map(value -> (int) value).toList();
        Integer valueReal = calculateNumbers(values);
        return valueReal.equals(number);
    }
    public static Integer calculateNumbers(List<Integer> values){
        int size = values.size();
        return values.stream()
                .mapToInt(num -> (int) Math.pow(num, size))
                .sum();
    }
}
