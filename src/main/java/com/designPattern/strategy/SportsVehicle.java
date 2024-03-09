package com.designPattern.strategy;

public class SportsVehicle extends Vechile {


    SportsVehicle(String name, DriveStrategy d) {
        this.vechileType = name;
        this.driveStrategy=d;
    }

    public void print(){
        System.out.println("Vehicle Name is " + getVechileType());
    }


}
