package com;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Timezone {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-dd-MM hh:mm:ss Z");
        format.setTimeZone(TimeZone.getTimeZone("Europe/London"));
        System.out.println(format.format(date));
        format.setTimeZone(TimeZone.getTimeZone("Asia/Calcutta"));
        System.out.println(format.format(date));

        ZonedDateTime zdtAtET = ZonedDateTime.now(ZoneId.of("Asia/Calcutta"));
       String s =  zdtAtET.format(DateTimeFormatter.ofPattern("yyyy-dd-MM hh:mm:ss Z"));

        System.out.println(s);
    }
}
