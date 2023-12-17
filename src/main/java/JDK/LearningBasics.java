package JDK;


import java.io.IOException;

public class LearningBasics {
    public static void main(String[] args) throws IOException {

        for (SampleEnum s : SampleEnum.values()) {
            System.out.println(s.name());
        }

        System.out.println(SampleEnum.valueOf("MONDAY").name());

        System.out.println(SampleEnum.MONDAY.getEnumSampleDay(1));

    }
}
