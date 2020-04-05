package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FailSafe {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList();
        list.add("Nitin");
        list.add("Nitin1");
        list.add("Nitin2");
        List list1 = new ArrayList();
        list1 = (ArrayList) list.clone();
        Iterator iterator = list1.listIterator();

        while (iterator.hasNext()) {

            if (iterator.next() == "Nitin1") {
                list.remove("Nitin1");
            }
        }
        System.out.println(list);
        System.out.println(list1);
    }
}
