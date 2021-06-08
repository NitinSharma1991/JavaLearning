package com.Threading;

//public class Deadlock {
class Friend {
    private final String name;

    public Friend(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }

    public String getName() {
        return this.name;
    }

    public synchronized void bow(Friend bower) {
        System.out.format("%s: %s"
                        + "  has bowed to me!%n",
                this.name, bower.getName());
        bower.bowBack(bower);
    }
//    }

    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s"
                        + " has bowed back to me!%n",
                this.name, bower.getName());
    }
}
