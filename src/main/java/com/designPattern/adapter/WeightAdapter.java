package com.designPattern.adapter;

public class WeightAdapter {

    WeightClass weightClass;

    public WeightAdapter(WeightClass weightClass) {
        this.weightClass = weightClass;
    }

    public int getMeWeightInPounds() {
        return (int) (weightClass.getMeWeightInKG() * 2.20462);
    }
}
