package com.designPattern.strategy;

import lombok.Getter;

public class Vechile {

    DriveStrategy driveStrategy;

    @Getter
    String vechileType;

    public String drive() {
        return driveStrategy.drive();
    }
}
