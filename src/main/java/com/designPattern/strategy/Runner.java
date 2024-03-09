package com.designPattern.strategy;

public class Runner {



    public static void main(String[] args) {

        Vechile passengerVehicle = new PassengerVehicle("Passenger Vehicle", new SportsDrive());
        Vechile sportVehicle = new SportsVehicle("Sports Vehicle", new NormalDrive());
        Vechile normalVehicle = new NormalVehicle("Normal Vehicle", new SportsDrive());

        System.out.println(passengerVehicle.getVechileType() + " " + passengerVehicle.drive());
        System.out.println(sportVehicle.getVechileType() + " " + sportVehicle.drive());
        System.out.println(normalVehicle.getVechileType() + " " + normalVehicle.drive());

    }
}
