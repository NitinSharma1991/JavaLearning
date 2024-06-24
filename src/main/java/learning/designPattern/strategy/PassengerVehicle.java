package learning.designPattern.strategy;

public class PassengerVehicle extends Vehicle {

    PassengerVehicle(String name, DriveStrategy d) {
        this.vehicleType = name;
        this.driveStrategy=d;
    }

    public void print() {
        System.out.println("Vehicle Name is " + getVehicleType());
    }

}
