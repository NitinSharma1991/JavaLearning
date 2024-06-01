package JDK.variable;

public class Variable {
    int anInt = 10;
    static int two = 11;


    public static void main(String[] args) {
        Variable variable = new Variable();
        two = two + variable.anInt;
        System.out.println(two);
        Variable variable1e = new Variable();
        two = two + 100;
        System.out.println(two);
        Thread thread = new Thread(() -> System.out.println("This is runnable"));
        thread.start();
    }
}
//-2147483647