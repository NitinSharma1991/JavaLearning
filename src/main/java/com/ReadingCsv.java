package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReadingCsv {

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Intellij Code\\JavaLearning\\src\\main\\resources\\Item.csv"));
        String row = null;
        while ((row = reader.readLine()) != null) {
            assert row != null;
            String[] read = row.split(",");
            System.out.println(Arrays.toString(read));
        }


    }


}
