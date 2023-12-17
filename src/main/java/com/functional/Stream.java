package com.functional;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10, 15, 8, 8, 98, 49, 25, 98, 32);

        //Number starting with 1 in list;

        System.out.println("Number starting with 1 in list " + myList.stream().filter(num -> num.toString().charAt(0) == '1').toList());

        //Duplicates Elements in the list
        System.out.println("Duplicates Elements in the list " + myList.stream().collect(Collectors.groupingBy(id -> id, Collectors.counting())).entrySet().stream().filter(id -> Math.toIntExact(id.getValue()) > 1).map(Map.Entry::getKey).collect(Collectors.toList()));

        //Find first element in the list
        System.out.println("Find first element in the list " + myList.stream().findFirst().get());

        //Total number of elements in list
        System.out.println("Total number of elements in list " + myList.stream().count());

        //MAx in list
        System.out.println("Max number in list " + myList.stream().max(Integer::compare).get());

        //find the first non-repeated character
        String input = "Java  articles are Awesome";

        Optional<Character> a = input.chars().mapToObj(Character::toLowerCase).collect(Collectors.groupingBy(id -> (char) id.intValue(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(id -> id.getValue() == 1L).map(Map.Entry::getKey).findFirst();
        System.out.println("find the first non-repeated character " + (char) (a.isPresent() ? a.get() : -1));

        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        System.out.println("String count greater than 1 in the list " + names.stream().collect(Collectors.groupingBy(id -> id, Collectors.counting())).entrySet().stream().filter(id -> Math.toIntExact(id.getValue()) > 1).toList());

        String s = "string data to count each character";

        Map<Character, Long> map = s.chars().mapToObj(Character::toLowerCase).collect(Collectors.groupingBy(id -> (char) id.intValue(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("string data to count each character " + map);


    }
}
