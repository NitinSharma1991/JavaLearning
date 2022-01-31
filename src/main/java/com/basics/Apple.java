package com.basics;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

public class Apple implements Cloneable {
    private String color;

    public Apple(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Apple a1 = new Apple("green");
        Apple a2 = new Apple("green");

        HashSet<Apple> set = new HashSet<>();

        //hashMap stores apple type and its quantity
        HashMap<Apple, Integer> m = new HashMap<>();
        set.add(a2);
        set.add(a1);
        System.out.println(set.size());
        System.out.println(m.put(a1, 10));
        m.put(a2, 20);
        System.out.println(m.get(new Apple("green")));
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Apple))
            return false;
        if (obj == this)
            return true;
        return this.color.equals(((Apple) obj).color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}