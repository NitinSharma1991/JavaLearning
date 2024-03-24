package interview.lld.parking;

import interview.lld.parking.charge.ParkingChargeStrategy;

public interface Parking {

    Ticket park(Vehicle vehicle) throws ParkingFullException;

    int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;

}