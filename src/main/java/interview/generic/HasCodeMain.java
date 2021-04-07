package interview.generic;

public class HasCodeMain {

    public static void main(String[] args) {
        People a = new People();
        a.setId(10);
        a.setName("Nitin");

        People a1 = new People();
        a1.setId(10);
        a1.setName("Nitin1");
        System.out.println(a1.equals(a));
    }
}
