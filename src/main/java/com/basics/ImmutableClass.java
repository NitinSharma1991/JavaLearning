package com.basics;

import java.util.ArrayList;

public final class ImmutableClass {
    final String name;
    final String nitin;
    final String sum;
    final int a;
    final ArrayList add;

    public ImmutableClass(String name, String nitin, String sum, int a, ArrayList add) {
        this.name = name;
        this.nitin = nitin;
        this.sum = sum;
        this.a = a;
        this.add = (ArrayList) add.clone();
    }

    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("Nitin");
        ImmutableClass immutableClass = new ImmutableClass("ka", "na", "10", 10, list);
        list.add("nitin1");
        System.out.println(immutableClass);


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
