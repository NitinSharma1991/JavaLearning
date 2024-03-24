package interview.lld.parking;

import interview.lld.parking.charge.FourWheelerWeekDayStrategy;
import interview.lld.parking.charge.TwoWheelerWeekendDayStrategy;

public class TestParking {

    public static void main(String[] args) throws ParkingFullException, InvalidVehicleNumberException {
        ParkingLot parkingLot = ParkingLot.getParkingLot();

        parkingLot.initializeParkingSlots(10, 10);

        Vehicle vehicle = new Vehicle(VehicleType.FOUR_WHEELER_VEHICLE, "Mh12");

        Ticket ticket = parkingLot.park(vehicle);
        System.out.println(ticket);

        Vehicle vehicle2 = new Vehicle(VehicleType.TWO_WHEELER_VEHICLE, "Mh13");

        Ticket ticket2 = parkingLot.park(vehicle2);
        System.out.println(ticket2);
        int cost1 = parkingLot.unPark(ticket2, new TwoWheelerWeekendDayStrategy());
        System.out.println(cost1);

        int cost2 = parkingLot.unPark(ticket, new FourWheelerWeekDayStrategy());
        System.out.println(cost2);

    }

}