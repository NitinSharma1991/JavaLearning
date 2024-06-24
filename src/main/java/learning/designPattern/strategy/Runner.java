package learning.designPattern.strategy;

public class Runner {



    public static void main(String[] args) {

        Vehicle passengerVehicle = new PassengerVehicle("Passenger Vehicle", new SportsDrive());
        Vehicle sportVehicle = new SportsVehicle("Sports Vehicle", new NormalDrive());
        Vehicle normalVehicle = new NormalVehicle("Normal Vehicle", new SportsDrive());

        System.out.println(passengerVehicle.getVehicleType() + " " + passengerVehicle.drive());
        System.out.println(sportVehicle.getVehicleType() + " " + sportVehicle.drive());
        System.out.println(normalVehicle.getVehicleType() + " " + normalVehicle.drive());

    }
}
