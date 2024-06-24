package learning.designPattern.adapter;

public final class WeightAdapter {

    WeightClass weightClass;

    public WeightAdapter(WeightClass weightClass) {
        this.weightClass = weightClass;
    }

    public int getMeWeightInPounds() {
        return (int) (weightClass.getMeWeightInKG() * 2.20462);
    }
}
