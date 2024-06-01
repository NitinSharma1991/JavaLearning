package com.Threading;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LargeString {

    public static void main(String[] args) throws IOException {

        Instant now = Instant.now();
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        Map<Character, AtomicInteger>[] results = new Map[numOfThreads];
        System.out.println("Number of Threads " + numOfThreads);
        Path start = Paths.get("C:\\XPS\\Nitin Resume\\output-onlinefiletools.txt");
        Collection<Path> res = Files.walk(start, 2).collect(Collectors.toCollection(ArrayList::new));


        List<CompletableFuture<Void>> completableFutureList = new ArrayList<>();
        AtomicInteger atomicIntegerAns;
        try (Stream<String> stringStream = Files.lines(start, StandardCharsets.UTF_8)) {
            AtomicInteger currentIndex = new AtomicInteger();
            stringStream.forEach((line) -> {
                int idx = currentIndex.get() % results.length;
                if (results[idx] == null) {
                    results[idx] = new HashMap<>();
                }
                CompletableFuture<Void> cs = CompletableFuture.runAsync(() -> countCharsInChunk(line, results[idx]), executorService);
                // Increment thread index for the next chunk
                currentIndex.addAndGet(1);
                completableFutureList.add(cs);
            });
        }

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));
        completableFuture.thenAccept(v -> System.out.println("All tasks completed")).join();
        executorService.shutdown();
        Map<Character, AtomicInteger> combinedResult = new HashMap<>();
        for (Map<Character, AtomicInteger> threadResult : results) {
            if (threadResult != null) {
                for (Map.Entry<Character, AtomicInteger> entry : threadResult.entrySet()) {
                    combinedResult.merge(entry.getKey(), entry.getValue(), (existingValue, newValue) -> {
                        existingValue.addAndGet(newValue.get());
                        return existingValue;
                    });
                }
            }
        }
        System.out.println(Duration.between(now, Instant.now()).toMillis());
        atomicIntegerAns = new AtomicInteger(0);
        for (AtomicInteger atomicInteger : combinedResult.values())
            atomicIntegerAns.addAndGet(atomicInteger.get());
        System.out.println(atomicIntegerAns.get());
    }

    private static void countCharsInChunk(String chunk, Map<Character, AtomicInteger> result) {
        for (char c : chunk.toCharArray()) {
            result.computeIfAbsent(c, k -> new AtomicInteger()).incrementAndGet();
        }
    }

}
