package JDK;

public class BitWise {

    public static void main(String[] args) {
        int i = 4;
        int j = 6;
//        System.out.println(i | j);
//        System.out.println(i ^ j);
//        System.out.println(i & j);  //100
//        System.out.println(i | j);  //1 1 0
//        System.out.println(i ^ j);  //0 1 0
//        System.out.println(~i);  //0 1 0
//        System.out.println(Math.pow(2, 0));  //0 1 0
        System.out.println(convertBinaryToDecimal(String.valueOf(100000)));  //0 1 0
        System.out.println(3 << 1);  //0 1 0
        System.out.println(convertDecimalToBinary(3));  //0 1 0
    }

    private static int convertBinaryToDecimal(String num) {
        int i = 0;
        int len = num.length() - 1;
        int ans = 0;
        while (i < num.length()) {
            int n = num.charAt(i) - '0';
            ans += (int) (n * Math.pow(2, len));
            len--;
            i++;
        }

        return ans;

    }

    private static String convertDecimalToBinary(int num) {

        String ans = "";
        while (num > 0) {
            int rem = num % 2;
            ans = rem + ans;
            num /= 2;
        }

        return ans;
    }
}







