package com.designPattern.adapter;

public class Runner {

    public static void main(String[] args) {
        WeightAdapter weightAdapter = new WeightAdapter(new WeightClass());
        System.out.println(weightAdapter.getMeWeightInPounds());
    }
}
