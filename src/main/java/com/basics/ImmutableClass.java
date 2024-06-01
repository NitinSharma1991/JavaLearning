package com.basics;

import lombok.Getter;

import java.util.ArrayList;
import java.util.function.Function;

public final class ImmutableClass {
    @Getter
    final String name;
    @Getter
    final String nitin;
    @Getter
    final String sum;
    @Getter
    final int a;
    @Getter
    final ArrayList<String> add;
    final Apple apple;
    Function<String, Integer> function = String::hashCode;

    public ImmutableClass(String name, String nitin, String sum, int a, ArrayList<String> add, Apple apple) {
        this.name = name;
        this.nitin = nitin;
        this.sum = sum;
        this.a = a;
        this.add = new ArrayList<>(add);
        this.apple = apple;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<String> list = new ArrayList<>();
        list.add("siting");
        Apple apple = new Apple("apple");
        ImmutableClass immutableClass = new ImmutableClass("ka", "na", "10", 10, list, apple);
        list.add("siting1");
        immutableClass.getApple().setColor("Red");
        System.out.format("First Immutable object output = %s \n", immutableClass);
        Apple apple1 = new Apple("red");
        ImmutableClass immutableClass1 = new ImmutableClass("ka", "na", "10", 10, list, apple1);
        System.out.format("Second Immutable object output = %s\n", immutableClass1);
        list.add("Kafka");
        System.out.format("Second Immutable obj fruit output = %s\n", immutableClass1.getApple());
        System.out.format("Hash Code for given string %s is %s\n",
                immutableClass1.getApple().getColor(),
                immutableClass1.function.apply(immutableClass1.getApple().getColor()));
    }

    public Apple getApple() throws CloneNotSupportedException {
        return (Apple) apple.clone();
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

}
