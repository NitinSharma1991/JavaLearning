package interview.string;

import java.util.ArrayList;
import java.util.List;




public class ReverseString {
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        String s = "KKAt";
//        System.out.println(fib(4));
//        System.out.println(reverseString(s));

        subSet(4);
        System.out.println(list);

        System.out.println(powerNum(5,3));
    }

    private static int powerNum(int i, int i1) {

        if(i1==0) return 1;

        int a = powerNum(i,i1-1);

        return a*i;
    }


    private static void subSet(int s) {
        if (s == 0) {
            return ;
        }
        list.add(s);
        subSet(s - 1);
        System.out.println(s);


    }

    private static String reverseString(String s) {

        if (s.isEmpty()) return "";
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static int fib(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }


}

