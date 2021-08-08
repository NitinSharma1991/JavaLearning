package com;

import java.util.*;

public class Timezone {

    public static void main(String[] args) {
        int[] heights = {5, 1, 2, 3, 4};
        Set<String> list = new HashSet<>();
        System.out.println(heightChecker(heights));
        list.add("Nitin2");
        list.add("Nitin");
        list.add("Nitin1");
        list.add("Toby1");
        list.add("Toby");

        String s = list.stream().distinct().filter(i -> i.equals("Toby")).findFirst().orElse(null);
        System.out.println(s);
        Map<String, Integer> map = new HashMap<>();
        map.put("Toby", 1);
        if (map.get("Toby") < map.getOrDefault(null, 0)) {
            System.out.println("Yes");
        }
        long a = System.currentTimeMillis();
        List<String> list1 = new ArrayList<>();
        for(int i=0;i<100000;i++){
            if(i%2==0)
                list1.add("Nitin");
            else list1.add("ANKITA");
        }


        System.out.println(list1.stream().distinct().count());
        long b = System.currentTimeMillis() - a;
        System.out.println(b);



        nitin(1,2);


//        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
//
//        executorService.scheduleAtFixedRate(new CleaningScheduler(), 10, 10, TimeUnit.SECONDS);

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

    private  static  void nitin(int a, int b) {
        System.out.println("Called");
    }
    private static void nitin(Integer a, Integer b) {
        System.out.println("Called 2");
    }

    private static int heightChecker(int[] heights) {
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
