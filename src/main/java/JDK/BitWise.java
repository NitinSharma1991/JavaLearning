package JDK;

public class BitWise {

    public static void main(String[] args) {
        int i = 4;
        int j = 6;
        System.out.println(i | j);
        System.out.println(i ^ j);
        System.out.println(i & j);  //100
        System.out.println(~i);  //0 1 0
        System.out.println(Math.pow(2, 0));  //0 1 0
        System.out.println(convertBinaryToDecimal(String.valueOf(1001)));  //0 1 0
        System.out.println(3 << 1);  //0 1 0
        System.out.println(convertDecimalToBinary(4));  //0 1 0
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

        StringBuilder ans = new StringBuilder();
        while (num > 0) {
            int rem = num % 2;
            ans.insert(0, rem);
            num /= 2;
        }
        return (ans.isEmpty()) ? "0" : ans.toString();
    }
}


//Bit Wise & Both are same 1 then only it will return 1
/*
* 1 0 -> 0
* 1 0 -> 0
* 0 0 -> 0
* 1 1 -> 0
* */

//Bit Wise | if any one of them has 1 it will return 1
/*
 * 1 0 -> 1
 * 1 0 -> 1
 * 0 0 -> 0
 * 1 1 -> 1
 * */

//Bit Wise XOR ^ if any of the digit has 1 it will return 1 otherwise 0
/*
 * 1 0 -> 1
 * 1 0 -> 1
 * 0 0 -> 0
 * 1 1 -> 0
 * */









