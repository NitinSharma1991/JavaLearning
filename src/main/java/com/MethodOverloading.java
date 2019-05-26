package com;

public class MethodOverloading {

    public static void main(String[] args) {
        System.out.println(getInt(1));
    }

    public static Object getInt(int a) {
        return a;
    }

    public static float getInt(float a) {
        return a;
    }

    public static double getInt(double a) {
        return a;
    }

}
