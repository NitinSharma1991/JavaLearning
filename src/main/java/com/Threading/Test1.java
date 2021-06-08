package com.Threading;

enum Animals {
    DOG("WOOF"), FISH("BRUBLE");
    String s;

    Animals(String s) {
        this.s = s;
    }
}

public class Test1 extends Thread {
    static Animals s1;

    public static void main(String[] args) {
        Test1 t = new Test1();
        Test1 t2 = new Test1();
        System.out.println(Animals.DOG.s);
        t.start();
        t2.start();
    }

    public void run() {
        System.out.println("Run");
    }
}
