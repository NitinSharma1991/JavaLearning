package com;

public class BinaryToDecimal {

    static char hex[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static int getDecimalFromBinary(int a) {

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
        System.out.println(getDecimalFromBinary(111101));
        System.out.println(conBinaryToHexDecimal(61));
        System.out.println(decimalToBinary(61));
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

    private static String conBinaryToHexDecimal(int a) {
        String binary = decimalToBinary(a);
        int decimal = getDecimalFromBinary(Integer.parseInt(binary));
        String hexaDecimal = "";

        while (decimal > 0) {
            int i = decimal % 16;
            hexaDecimal = hex[i] + hexaDecimal;
            decimal = decimal / 16;
        }

        return hexaDecimal;
    }

    private static String decimalToBinary(int a) {
        String binary = "";
        int i = 0;

        while (a > 0) {
            binary = (a % 2) + binary;
            a = a / 2;
        }

        return binary;
    }
}
