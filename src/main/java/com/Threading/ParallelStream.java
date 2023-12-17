package com.Threading;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStream {

    public static void main(String[] args) throws InterruptedException {

        int cores = ForkJoinPool.getCommonPoolParallelism();
        System.out.println(cores);
        List<Integer> listOfNumbers = IntStream.rangeClosed(0, 50)
                .boxed().toList();
//        long a = System.currentTimeMillis();
//        listOfNumbers.forEach(number -> {
//            System.out.println("Sequential" + number + " " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println("Time taken" + (System.currentTimeMillis() - a));

        long a1 = System.currentTimeMillis();


        listOfNumbers.forEach(number -> {
            System.out.println("Parallel " + number + " " + Thread.currentThread().getName());
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });

        System.out.println("Time taken" + (System.currentTimeMillis() - a1));

    }


}


