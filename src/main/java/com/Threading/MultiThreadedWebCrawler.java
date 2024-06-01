package com.Threading;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class MultiThreadedWebCrawler {

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> result = ConcurrentHashMap.newKeySet();
        String hostname = getHostname(startUrl);

        ExecutorService executor = Executors.newFixedThreadPool(64);
        result.add(startUrl);
        crawl(result, startUrl, hostname, executor, htmlParser);
        executor.shutdown();

        try {
            executor.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ArrayList<>(result);
    }

    private String getHostname(String url) {
        int idx = url.indexOf('/', 7);
        return (idx != -1) ? url.substring(0, idx) : url;
    }

    private void crawl(Set<String> result, String start, String hostname, ExecutorService executor, HtmlParser htmlParser) {
        List<Future> futures = new ArrayList<>();
        for (String url : htmlParser.getUrls(start)) {
            if (url.startsWith(hostname) && result.add(url)) {
                futures.add(executor.submit(() -> crawl(result, url, hostname, executor, htmlParser)));
            }
        }
        for (Future f : futures) {
            try {
                f.get(100, TimeUnit.SECONDS);
            } catch (Exception e) {
                f.cancel(true);
                e.printStackTrace();
            }
        }
    }
}


class HtmlParser {

    public String[] getUrls(String start) {
        return new String[2];
    }
}
