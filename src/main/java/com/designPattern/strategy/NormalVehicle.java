package com.designPattern.strategy;

public class NormalVehicle extends Vechile{

    NormalVehicle(String name, DriveStrategy d) {
        this.vechileType = name;
        this.driveStrategy = d;
    }

    public void print() {
        System.out.println("Vehicle Name is " + getVechileType());
    }
}
