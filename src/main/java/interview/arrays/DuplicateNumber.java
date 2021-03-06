package interview.arrays;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DuplicateNumber {
    static int[] a = {5, 1, 2, 6, 4, 4, 5};

    public static void main(String[] args) {
        // First date
        LocalDate dt = LocalDate.parse("2018-11-14");
        System.out.println(dt);

        // Second date
        LocalDate dt1 = LocalDate.parse("2018-11-14");
        System.out.println(dt1);

        // Compare both dates
        System.out.println(dt1.compareTo(dt));

        ZonedDateTime now = ZonedDateTime.now(ZoneId.systemDefault());
        ZonedDateTime nextrun = now.withHour(17).withMinute(15).withSecond(0);
        nextrun = now.compareTo(nextrun) > 0 ? nextrun.plusDays(1) : nextrun;

        duplicateNumbers(a);
    }

    private static void duplicateNumbers(int[] a) {
        for (int i = 0; a.length > i;
             i++) {
            if (a[Math.abs(a[i])] < 0)
                System.out.println("duplicate number " + Math.abs(a[i]));
            else
                a[Math.abs(a[i])] = -1 * a[Math.abs(a[i])];
        }
    }
}
