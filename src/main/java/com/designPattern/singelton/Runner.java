package com.designPattern.singelton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 10; i++) {
            executorService.submit(() -> {
                DatabaseConnection db = DatabaseConnection.getDb();
                System.out.println("Thread name " + Thread.currentThread() + "Hash Code for Object is " + db.print());
            });

        }
    }
}
