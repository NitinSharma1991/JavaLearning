package learning.designPattern.strategy;

import lombok.Getter;

public class Vehicle {

    DriveStrategy driveStrategy;

    @Getter
    String vehicleType;

    public String drive() {
        return driveStrategy.drive();
    }
}
