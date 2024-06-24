package interview;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Athena {

    public static void main(String[] args) throws IOException {

        Instant now = Instant.now();
        int numOfThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        Map<Character, AtomicInteger>[] results = new Map[numOfThreads];
        System.out.println("Number of Threads " + numOfThreads);
        Path path = Paths.get("C:\\XPS\\Nitin Resume\\output-onlinefiletools.txt");
        AtomicInteger atomicIntegerAns;
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            String s;
            int threadIndex = 0;
            while ((s = bufferedReader.readLine()) != null) {
                final int currentIndex = threadIndex;
                if (results[currentIndex] == null) {
                    results[currentIndex] = new HashMap<>();
                }
                String finalS = s;
                executorService.execute(() -> countCharsInChunk(finalS, results[currentIndex]));

                // Increment thread index for the next chunk
                threadIndex = (threadIndex + 1) % (numOfThreads);
            }
            executorService.shutdown();
            while (!executorService.isTerminated()) {
                // Wait for all threads to finish
            }
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
        }
        System.out.println(atomicIntegerAns.get());
    }

    private static void countCharsInChunk(String chunk, Map<Character, AtomicInteger> result) {
        for (char c : chunk.toCharArray()) {
            result.computeIfAbsent(c, k -> new AtomicInteger()).incrementAndGet();
        }
    }
}
