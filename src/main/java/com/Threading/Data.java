package com.Threading;

import java.util.Arrays;

public enum Data {
    ORG("4", "Nitin"), ORG1("5", "Mi");

    private final String key;
    private final String value;

    Data(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public String getOrganization(Data key) {
        return Arrays.stream(Data.values()).filter(t -> t.equals(key)).toString();

    }
}
