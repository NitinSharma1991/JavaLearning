package com;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        /*List<Laptops> laptops = new ArrayList<Laptops>();
        laptops.add(new Laptops("Dell", 11, 19));
        laptops.add(new Laptops("Sony", 14, 13));
        laptops.add(new Laptops("Apple", 16, 21));
        laptops.add(new Laptops("Apple", 9, 13));

        Integer[] array = laptops.stream().toArray(Integer[]::new);*/

        List<String> list = new ArrayList<>();
        list.add("Beautiful");
        list.add("kaka");
        list.add("nitin");
        list.add("mohan");
        list.add("list");
        list.add("mohitq");
        list.add("mohit");
        list.add("mohit1");
        list.add("mohit2");
        list.add("mohit3");


        System.out.println("Minimum Steps to reach song " + findNumber(list, 9, "mohit3"));

        LinkedList<String> linkedList = list.stream().collect(Collectors.toCollection(LinkedList::new));


        /*Collections.sort(laptops);
         *//*   for (Laptops a : laptops)
            System.out.println(a);*//*

        List<Users> users = new ArrayList<Users>();
        users.add(new Users("Sony", 16, 19));
        users.add(new Users("Dell", 16, 19));
        users.add(new Users("Apple", 16, 29));
        users.add(new Users("Apple", 16, 13));*/

        /*Comparator<Laptops> laptopsComparator = (o1, o2) -> {
//            int comp = o1.getName().compareTo(o2.getName());
            if (o1.getRam() > o2.getRam()) return 1;
            else {
                int i = o1.getName().compareTo(o2.getName());
                if (i > 0) return i;
                else return -1;
            }
        };
        Collections.sort(laptops, laptopsComparator);
        System.out.println(laptops);*/
       /* List<Laptops> laptopsList = laptops.stream()
//                .filter(laptop -> laptop.getName() != "Apple")
                .sorted((o1, o2) -> {
//            int comp = o1.getName().compareTo(o2.getName());
                    if (o1.getSize() > o2.getSize()) return 1;
                    else if (o1.getSize() == o2.getSize()) {
                        if (o1.getName().compareTo(o2.getName()) > 0) return 1;
                        else return -1;
                    }
                    return -1;
                })
                .collect(Collectors.toList());
        for (Laptops a : laptopsList)
//            a.setName("kaka");
            System.out.println(a);*/
    }

    public static int findNumber(List<String> list, int k, String a) {
        ListIterator listIterator = list.listIterator(k);
        ListIterator listIterator1 = list.listIterator(k);
        int count = 0, next = -1, previous = 0;


        while (listIterator.hasNext()) {
            next += 1;
            if (listIterator.next().equals(a)) {
                count += 1;
                break;
            }

        }
        if (!(count > 0)) {
            ListIterator listIterator2 = list.listIterator();
            while (listIterator2.hasNext() || count == k) {
                next += 1;
                count += 1;
                if (listIterator2.next().equals(a)) {
                    break;
                }

            }
        }

        count = 0;
        
        while (listIterator1.hasPrevious()) {
            previous += 1;
            if (listIterator1.previous().equals(a)) {
                count += 1;
                break;
            }

        }
        if (!(count > 0)) {
            ListIterator listIterator3 = list.listIterator(list.size());
            while (listIterator3.hasPrevious() || count == k) {
                previous += 1;
                count += 1;
                if (listIterator3.previous().equals(a)) {
                    break;
                }

            }
        }

        System.out.println("Next " + next);
        System.out.println("Previous " + previous);

        if (next >= previous) return previous;
        else return next;

    }
}
