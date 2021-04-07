package com;

import java.util.ArrayList;
import java.util.List;

public class Timezone {

    public static void main(String[] args) {
        int[] heights = {5,1,2,3,4};
        List<String> list = new ArrayList<>();
        System.out.println(heightChecker(heights));

        list.add("Nitin");
        list.add("Nitin");
        list.add("Nitin");
        list.add("Toby ");
        list.add("Toby ");

        String a = list.stream().distinct().filter(item -> item.trim().equals("Toby")).findAny().orElse(null);
        System.out.println(a);

//        String a = "02/14/2020";
//        LocalDate localDate = LocalDate.parse(a, DateTimeFormatter.ofPattern("M/dd/yyyy"));
//        LocalDateTime time = LocalDateTime.of(localDate, LocalDateTime.now().toLocalTime());
//        System.out.println(time);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
//        System.out.println(LocalDate.parse(a,formatter));
//        System.out.println(formatter.format(LocalDate.parse(a,formatter)));
//        Users users = new Users();
//
//        users.setName(Data.ORG1.getOrganization();
//        System.out.println(users);
  /*      String a = null;
        assert a != null;
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm:ss")));

        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss Z");
        format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(format.format(date));
        format.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        System.out.println(format.format(date));

        ZonedDateTime zdtAtET = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
        String s = zdtAtET.format(DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm:ss Z"));

        System.out.println(s);*/
    }

    private static  int heightChecker(int[] heights) {
        int[] heightToFreq = new int[101];

        for (int height : heights) {
            heightToFreq[height]++;
        }

        int result = 0;
        int curHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (heightToFreq[curHeight] == 0) {
                curHeight++;
            }

            if (curHeight != heights[i]) {
                result++;
            }
            heightToFreq[curHeight]--;
        }

        return result;


    }
}
