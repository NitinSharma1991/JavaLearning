package com.DataStructure;

public class LLExample {

    public static void main(String[] args) {
        LList list = new LList();
        list.insert("Kaka");
        list.insert("Nitin");
        list.insert("Nupur");
        list.insert("Apurva");
        list.insert("Swati");
        list.insertAt(6, "love");
        list.print(list.head);
        System.out.println(" ");
        list.print(list.reverse(list.head));
    }
}
