package com.Threading;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelStream {

    public static void main(String[] args) throws InterruptedException {

        int cores = ForkJoinPool.getCommonPoolParallelism();
        System.out.println(cores);
        List<Integer> listOfNumbers = IntStream.rangeClosed(0, 51)
                .boxed().toList();

        Instant a1 = Instant.now();
        ExecutorService executorService = Executors.newFixedThreadPool(cores);


//        listOfNumbers.forEach((num) -> CompletableFuture.runAsync(() -> isDivisibleByTwo(num)));
        List<CompletableFuture<Boolean>> completableFutureList = listOfNumbers.stream().map(num -> CompletableFuture.supplyAsync(() -> isDivisibleByTwo(num), executorService)).toList();
//        CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0])).join();
        System.out.println("Time taken " + (Duration.between(a1, Instant.now()).toMillis()));
        try {
            executorService.shutdown();
        } catch (Exception ignored) {

        }


    }


    private static boolean isDivisibleByTwo(int num) {
        System.out.println("Number " + " " + num + " is divisible by 2 " + (num % 2 == 0));
        return num % 2 == 0;
    }


}


