package learning.designPattern.strategy;

public class SportsVehicle extends Vehicle {


    SportsVehicle(String name, DriveStrategy d) {
        this.vehicleType = name;
        this.driveStrategy=d;
    }

    public void print(){
        System.out.println("Vehicle Name is " + getVehicleType());
    }


}
