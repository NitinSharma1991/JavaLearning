package JDK;

import java.util.Collections;
import java.util.List;

public class JavaGenerics {

    public static void main(String[] args) {

        printName("Nitin");
        printName(10);
        printName(10.10);
        printName(1L);
        System.out.println(getName("Nitin", 10));
        System.out.println(getName(10, "Kaka"));
        System.out.println(getName(List.of(1, 2, 3, 4)));
    }

    static <T> void printName(T name) {
        System.out.println(name);
    }

    static <T, K> T getName(T name, K type) {
        System.out.println(type);
        return name;
    }


    static List<?> getName(List<? extends Number> name) {
        return Collections.unmodifiableList(name);
    }


}
