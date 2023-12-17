package com;

public class BinaryToDecimal {

    static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private static int getDecimalFromBinary(int a) {

        int decimal = 0;
        int power = 0;

        while (true) {
            if (a == 0) break;
            else {
                int temp = a % 10;
                decimal += (int) (temp * Math.pow(2, power));
                a = a / 10;
                power++;
            }
        }
        return decimal;
    }

    public static void main(String[] args) {
        System.out.println(getDecimalFromBinary(11));
        System.out.println(conBinaryToHexDecimal(61));
        System.out.println(decimalToBinary(10));
        System.out.println(checkBinary(110));
    }

    private static boolean checkBinary(int a) {
        boolean status = true;
        while (true) {
            if (a == 0) break;
            else {
                int temp = a % 10;
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
        StringBuilder hexaDecimal = new StringBuilder();

        while (decimal > 0) {
            int i = decimal % 16;
            hexaDecimal.insert(0, hex[i]);
            decimal = decimal / 16;
        }

        return hexaDecimal.toString();
    }

    private static String decimalToBinary(int a) {
        StringBuilder binary = new StringBuilder();

        while (a > 0) {
            binary.insert(0, (a % 2));
            a = a / 2;
        }

        return binary.toString();
    }
}
