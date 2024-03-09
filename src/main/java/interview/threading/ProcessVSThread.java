package interview.threading;

import java.util.concurrent.Callable;

public class ProcessVSThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> System.out.println("Kaka is a football genius"));
        t1.start();

        Thread t2 = new Thread(() -> {
            Callable<String> callable = () -> "I am the best";

            try {
                System.out.println(callable.call());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        t2.start();

        System.out.println("Task is completed");

    }

}
