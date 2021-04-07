package com.Threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Thread.sleep;

public class CF {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Object result;
        CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<? extends String> future1 = CompletableFuture.supplyAsync(() -> "Nitin");
        CompletableFuture future2 = CompletableFuture.supplyAsync(() -> {

            try {
                throw new Exception("I am here");
            } catch (Exception e) {
                e.printStackTrace();

            }
            return null;

        });

        CompletableFuture<? extends Object> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(10000);
                throw new Exception("Fatt gayi");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        });

        System.out.println("Nitin is here");
        CompletableFuture<? extends Void> future3 = CompletableFuture.allOf(future, future1, future4);
        future3.get();
        Stream stream = Stream.of(future, future1, future2).map(CompletableFuture::join);

        System.out.println(stream.collect(Collectors.joining(" ")));
    }
}
