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
        CompletableFuture<? extends String> future2 = CompletableFuture.supplyAsync(() -> "Sharma");
        CompletableFuture<? extends Object> future4 = CompletableFuture.supplyAsync(() -> {
            try {
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        });


        CompletableFuture<? extends Void> future3 = CompletableFuture.allOf(future, future1, future4);
        future3.get();
        Stream stream = Stream.of(future, future1, future2).map(CompletableFuture::join);

        System.out.println(stream.collect(Collectors.joining(" ")));
    }
}
