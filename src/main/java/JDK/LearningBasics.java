package JDK;


import interview.sort.Employee;

import java.io.IOException;
import java.lang.ref.WeakReference;

public class LearningBasics {
    public static void main(String[] args) throws IOException {

        for (SampleEnum s : SampleEnum.values()) {
            System.out.println(s.name());
            System.out.println(s.ordinal());
        }

        System.out.println(SampleEnum.valueOf("MONDAY").val);
        System.out.println(SampleEnum.valueOf("MONDAY").name());

        System.out.println(SampleEnum.MONDAY.getEnumSampleDay(10));

        WeakReference<Employee> weakReference = new WeakReference<>(new Employee());

        String url = "https://classroom.codingninjas.com/app/login?redirect=%2Fapp%2Fbootcamps%2FStriver232%3F&logged_out=true";
        int idx = url.indexOf('/', 8);
        String ans =  (idx != -1) ? url.substring(8, idx) : url;
        System.out.println(ans);

    }
}
