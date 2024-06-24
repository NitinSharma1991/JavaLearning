package JDK;

import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalProgramming {

    Predicate<String> predicate = (data) -> data.equals("siting");
    BiPredicate<String, String> biPredicate = String::equals;
    Supplier<String> supplier = () -> "This is a supplier";
    Function<String, Integer> function = (data) -> data.charAt(1) - 'A';
    Consumer<String> consumer = data -> System.out.println(data.toUpperCase());

    public static void main(String[] args) {
        FunctionalProgramming functionalProgramming = new FunctionalProgramming();
        if (functionalProgramming.predicate.test("Nitin"))
            System.out.println("Predicate is true");
        else System.out.println("Predicate is false");

        if (functionalProgramming.biPredicate.test("siting1", "siting1"))
            System.out.println("BiPredicate is true");
        else System.out.println("BiPredicate is false");

        System.out.println(functionalProgramming.supplier.get());
        System.out.println(functionalProgramming.function.apply("Ankita"));
        functionalProgramming.consumer.accept("Ankita");


    }

}


