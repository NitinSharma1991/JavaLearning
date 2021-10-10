package com.functional;

import com.Laptops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        List<Laptops> list = new ArrayList<>();

        list.add(new Laptops("Dell", 12, 256));
        list.add(new Laptops("Apple", 8, 256));
        list.add(new Laptops("Dell", 10, 256));
        list.add(new Laptops("Lenovo", 12, 256));

        list.stream().filter(laptops -> laptops.getName().equals("Apple")).forEach(System.out::println);

        Function<Integer, Integer> function = number -> number + 1;
        Function<Integer, Integer> mutiplyBy10 = number -> number * 10;

        BiFunction<Integer, Integer, Integer> biFunction = (number, number1) -> number * number1;

        System.out.println(mutiplyBy10.apply(90));
        System.out.println(biFunction.apply(20, 34));
        // Map Reduce

        List<Integer> list1 = Arrays.asList(1, 4, 5, 6, 7, 8);
        System.out.println(list1.stream().mapToInt(i -> i).sum());

    }
}
