package com;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class Timezone {

    public static void main(String[] args) {

        String date = "2013-04-10 00:00:00:0";
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(date.substring(0, 10), inputFormatter);
        System.out.println(date1);

        String a = Optional.of(date).map(id -> "Kafka").orElse("data is null");
        System.out.println(a);
    }
}
