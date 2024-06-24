package learning.Threading;

public class Main {
    private int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Main andNotify4 = new Main();
        andNotify4.testRaceCondition();
    }

    synchronized int counterAdd() {
        return counter++;
    }

    private void testRaceCondition() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    synchronized (Main.this) {
                        if (i == 1) {
                            System.out.println("Calling wait after count 1");
                            try {
                                Main.this.wait();
                                System.out.println("After wait is released :::: ");
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    counterAdd();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    if (i == 2) {
                        synchronized (Main.this) {
                            System.out.println("Before releasing the counter :::::");
                            Main.this.notify();
                            System.out.println("After releasing the counter :::::");
                        }
                    }
                    counterAdd();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(" Sum value is found as ::::: " + counter);
    }
}
