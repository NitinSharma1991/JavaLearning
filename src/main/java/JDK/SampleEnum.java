package JDK;

public enum SampleEnum {


    MONDAY(1, "Monday") {
        @Override
        public String getEnumSampleDay(int val) {
            return val + "Monday";
        }
    },
    TUESDAY(2, "Tuesday");


    private int val;
    private String day;

    SampleEnum(int val, String day) {
        this.val = val;
        this.day = day;
    }

    public int getVal() {
        return val;
    }


    public String getDay() {
        return day;
    }

    public String getEnumSampleDay(int val) {
        for (SampleEnum sampleEnum : values()) {
            if (sampleEnum.getVal() == val) return sampleEnum.getDay();
        }

        return null;
    }
}
