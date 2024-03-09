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

    }
}
