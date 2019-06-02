package com;

public class BinaryToDecimal {

    private static int getDecimalfromBinary(int a) {

        int decimal = 0;
        int power = 0;

        while (true) {
            if (a == 0) break;
            else {
                int temp = a % 10;
                decimal += temp * Math.pow(2, power);
                a = a / 10;
                power++;
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(getDecimalfromBinary(111101));
        System.out.println(checkBinary(110));
    }

    private static boolean checkBinary(int a) {
        boolean status = true;
        while (true) {
            if (a == 0) break;
            else {
                int temp = 0;
                temp = a % 10;
                if (temp > 1) {
                    status = false;
                    break;

                }
                a = a / 10;
            }
        }
        return status;
    }
}
