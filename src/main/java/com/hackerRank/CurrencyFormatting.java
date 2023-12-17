package com.hackerRank;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        String us, india, china, france;

        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        us = format.format(payment);
        format.setCurrency(Currency.getInstance(Locale.FRANCE));
        france = format.format(payment);
        format.setCurrency(Currency.getInstance(Locale.CHINA));
        china = format.format(payment);

        NumberFormat format2 = NumberFormat.getCurrencyInstance(Locale.of("en", "IN"));
        india = format2.format(payment);
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}