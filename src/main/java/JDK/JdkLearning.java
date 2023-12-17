package JDK;

public class JdkLearning {

    public static void main(String[] args) {

        var day = "Sat";
        String html = """ 
                Nitin
                kaka
                mohit
                """;
        System.out.println(html);
        switch (day) {
            case "Sat", "Sun" -> System.out.println(10);
            case "wed" -> System.out.println(8);
            default -> System.out.println(9);
        }

    }
}
