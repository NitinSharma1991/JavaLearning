package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.groupingBy;

public class GroupByLamda {

    public static void main(String[] args) {
        Path paths = Paths.get("C:\\Intellij Code\\JavaLearning\\src\\main\\resources\\Item.csv");
        List<Item> list = new ArrayList();

        try {
            BufferedReader bufferedReader = Files.newBufferedReader(paths, StandardCharsets.US_ASCII);
            String headerLine = bufferedReader.readLine();
            String line = bufferedReader.readLine();
            while (null != line) {
                String[] attributes = line.split(",");
                Item item = new Item();
                item.setCategory(attributes[2]);
                item.setName(attributes[1]);
                item.setId(Integer.parseInt(attributes[0]));
                list.add(item);
                line = bufferedReader.readLine();
            }
            Map<String, List<Item>> personByCity = new HashMap<>();
            /*for (Item p : list) {
                if (!personByCity.containsKey(p.getCategory())) {
                    personByCity.put(p.getCategory(), new ArrayList<>());
                }
                personByCity.get(p.getCategory()).add(p);
            }*/
            System.out.println("Person grouped by cities : " + personByCity);
            Map<String, Double> personByCity2 = list.parallelStream().collect(groupingBy(Item::getCategory, averagingInt(Item::getId)));
            // Let's see how we can group objects in Java 8
            Map<String, Double> personByCity1 = list.stream().collect(groupingBy(Item::getCategory, averagingInt(Item::getId)));
            System.out.println("Category : " + personByCity2);
            Map<Integer, List<Item>> personByAge = list.stream()
                    .collect(groupingBy(Item::getId));
//            personByAge.entrySet().stream().forEach(p -> System.out.println(p.getValue()));
            System.out.println("Id : " + personByAge);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
