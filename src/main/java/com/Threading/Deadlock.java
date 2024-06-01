package com.Threading;

//public class Deadlock {
record Friend(String name) {

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(() -> alphonse.bow(gaston)).start();
        new Thread(() -> gaston.bow(alphonse)).start();
    }

    public synchronized void bow(Friend bower) {
        System.out.format("%s: %s"
                        + "  has bowed to me!%n",
                this.name, bower.name());
        bower.bowBack(bower);
    }
//    }

    public synchronized void bowBack(Friend bower) {
        System.out.format("%s: %s"
                        + " has bowed back to me!%n",
                this.name, bower.name());
    }
}
