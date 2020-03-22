package com;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadingCsv {

    public static void main(String[] args) throws IOException {

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Intellij Code\\JavaLearning\\src\\main\\resources\\Item.csv"));
        String row = null;
        File file = new File("C:\\Intellij Code\\JavaLearning\\src\\main\\resources\\NewItem.csv");
        List list = new ArrayList();
        if (!file.exists()) file.createNewFile();
        while ((row = reader.readLine()) != null) {
            assert row != null;
            String[] read = row.split(",");
            list.add(read);
            System.out.println(Arrays.toString(read));
        }

        FileWriter fw = new FileWriter(file);
        list.forEach(a -> {
            try {

                String[] b = (String[]) a;
                StringBuilder builder = new StringBuilder();
                builder.append(b[0]);
                builder.append(",");
                builder.append(b[1]);
                builder.append(",");
                builder.append(b[2]);

                fw.append(builder);
                fw.append("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        reader.close();
        fw.flush();
        fw.close();
    }


}
