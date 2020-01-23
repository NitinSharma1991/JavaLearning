package com;

public class MethodOverloading {

    public static void main(String[] args) {
        System.out.println(getInt("Kaka"));

        Thread t1 = new Thread(() -> run(), "Nitin");
        Thread t2 = new Thread(() -> run(), "Kaka");
        t1.start();
        t2.start();
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

    public static String getInt(String a) {
        return a;
    }

    private static void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("Instance  hash:" + Singelton.getInstance().hashCode());
    }

}
