package learning.Threading;

import java.util.concurrent.Semaphore;

public class OddEven {

    public static void main(String[] args) throws InterruptedException {
        Semaphore oddSema = new Semaphore(1);
        Semaphore evenSema = new Semaphore(0);
        int n = 100;
        Runnable odd = () -> new Odd(oddSema, evenSema, n).run();
        Runnable even = () -> new Even(oddSema, evenSema, n).run();
        new Thread(odd).start();
        new Thread(even).start();


    }


    static class Odd {
        private final Semaphore oddSema;
        private final Semaphore evenSema;
        private final int n;

        public Odd(Semaphore oddSema, Semaphore evenSema, int n) {
            this.oddSema = oddSema;
            this.evenSema = evenSema;
            this.n = n;
        }


        public void run() {

            for (int i = 1; i <= n; i += 2) {
                try {
                    oddSema.acquire();
                    System.out.println("This is an Odd Number = " + i);
                    evenSema.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }

        }
    }

    static class Even {
        private final Semaphore oddSema;
        private final Semaphore evenSema;
        private final int n;

        public Even(Semaphore oddSema, Semaphore evenSema, int n) {
            this.oddSema = oddSema;
            this.evenSema = evenSema;
            this.n = n;
        }


        public void run() {
            for (int i = 2; i <= n; i += 2) {
                try {
                    evenSema.acquire();
                    System.out.println("This is an even Number = " + i);
                    oddSema.release();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
