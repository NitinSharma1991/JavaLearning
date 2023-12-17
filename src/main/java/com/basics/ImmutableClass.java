package com.basics;

import java.util.ArrayList;

import static com.Anargam.reverseString;

public final class ImmutableClass {
    final String name;
    final String nitin;
    final String sum;
    final int a;
    final ArrayList add;
    final Apple apple;

    public ImmutableClass(String name, String nitin, String sum, int a, ArrayList add, Apple apple) {
        this.name = name;
        this.nitin = nitin;
        this.sum = sum;
        this.a = a;
        this.add = (ArrayList) add.clone();
        this.apple = apple;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        ArrayList<String> list = new ArrayList<>();
        list.add("Nitin");
        Apple apple = new Apple("apple");
        ImmutableClass immutableClass = new ImmutableClass("ka", "na", "10", 10, list, apple);
        list.add("nitin1");
        immutableClass.getApple().setColor("Red");
        System.out.println(immutableClass);
        ImmutableClass immutableClass1 = new ImmutableClass("ka", "na", "10", 10, list, apple);
        System.out.println(immutableClass1);

        System.out.println(reverseString("Nitin"));


    }

    public Apple getApple() throws CloneNotSupportedException {
        return (Apple) apple.clone();
    }

    public String getName() {
        return name;
    }

    public String getNitin() {
        return nitin;
    }

    @Override
    public String toString() {
        return "ImmutableClass{" +
                "name='" + name + '\'' +
                ", nitin='" + nitin + '\'' +
                ", sum='" + sum + '\'' +
                ", a=" + a +
                ", add=" + add +
                ", apple=" + apple +
                '}';
    }

    public ArrayList getAdd() {
        return (ArrayList) add.clone();
    }

    public String getSum() {
        return sum;
    }

    public int getA() {
        return a;
    }
}
