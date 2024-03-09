package com.designPattern.strategy;

public class Vechile {

    DriveStrategy driveStrategy;

    String vechileType;

    public String getVechileType() {
        return vechileType;
    }

    public String drive() {
        return driveStrategy.drive();
    }
}
