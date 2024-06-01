package com.functional;

import java.util.*;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        List<Integer> myList = List.of(10, 15, 8, 8, 98, 49, 25, 98, 32);

//        //Number starting with 1 in list;
        System.out.println("Number starting with 1 in list " + myList.stream().filter(num -> num.toString().charAt(0) == '1').toList());

        String list = myList.stream().map(value -> "'" + value + "'").collect(Collectors.joining(","));
        System.out.println(list);

        //Duplicates Elements in the list

        System.out.println("Duplicates Elements in the list " + myList.stream().collect(Collectors.groupingBy(id -> id, Collectors.counting())).entrySet().stream().filter(id -> Math.toIntExact(id.getValue()) > 1).map(Map.Entry::getKey).toList());

        //Find first element in the list
        System.out.println("Find first element in the list " + myList.stream().findFirst().get());

        //Total number of elements in list
        System.out.println("Total number of elements in list " + (long) myList.size());

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

        Map<Character, Long> map = s.chars().mapToObj(Character::toLowerCase).collect(Collectors.groupingBy(id -> (char) id.intValue(),Collectors.counting()));
        System.out.println("string data to count each character " + map);


//        Question 1: Get transaction in 2011 and sort by value.

        SetUp setUp = new SetUp();
        List<Transaction> txnList = SetUp.getTransactions().stream().filter(txn -> txn.getYear() == 2011).sorted((Comparator.comparingInt(Transaction::getValue))).toList();
        System.out.println("Get transaction in 2011 and sort by value. " + txnList);

//        Question 2:Get all the cities of all the traders.
        List<String> cities = SetUp.getTransactions().stream().map(Transaction::getTrader).map(Trader::getCity).distinct().toList();
        System.out.println("Get all the cities of all the traders. " + cities);

//        Question 3: Finds all traders from Cambridge and sort them by name
        List<Trader> traderList = SetUp.getTransactions().stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).toList();
        System.out.println("Finds all traders from Cambridge and sort them by name " + traderList);

//        Question 4: Returns a string of all traders’ names sorted alphabetically
        List<String> traderNames = SetUp.getTransactions().stream().map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName)).map(Trader::getName).distinct().toList();
        System.out.println("Returns a string of all traders’ names sorted alphabetically " + traderNames);

//        Question 5 : Returns a string of all traders’ names sorted alphabetically Using Joining which is more efficient.

        String traderStr = SetUp.getTransactions().stream().map(Transaction::getTrader).sorted(Comparator.comparing(Trader::getName)).map(Trader::getName).distinct().collect(Collectors.joining(","));
        System.out.println("Returns a string of all traders’ names sorted alphabetically Using Joining which is more efficient. " + traderStr);

//        Question 8: Get Highest transaction
        int amount = SetUp.getTransactions().stream().map(Transaction::getValue).max(Comparator.comparingInt(o -> o)).stream().findFirst().orElse(0);
        System.out.println("Get Highest transaction " + amount);
//        Group transactions by currencies.

        Map<Currency, List<Transaction>> map1 = SetUp.getTransactions().stream().collect(Collectors.groupingBy(Transaction::getCurrency));
        System.out.println("Group transactions by currencies. " + map1);

    }
}
