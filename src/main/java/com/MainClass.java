package com;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Laptops> laptops = new ArrayList<Laptops>();
        laptops.add(new Laptops("Dell", 11, 19));
        laptops.add(new Laptops("Sony", 14, 13));
        laptops.add(new Laptops("Apple", 16, 21));
        laptops.add(new Laptops("Apple", 9, 13));

        Collections.sort(laptops);
     /*   for (Laptops a : laptops)
            System.out.println(a);*/

        List<Users> users = new ArrayList<Users>();
        users.add(new Users("Sony", 16, 19));
        users.add(new Users("Dell", 16, 19));
        users.add(new Users("Apple", 16, 29));
        users.add(new Users("Apple", 16, 13));

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
        List<Laptops> laptopsList = laptops.stream()
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
            System.out.println(a);
    }

}
