package interview.lld.parking;

import interview.lld.parking.charge.ParkingChargeStrategy;

public interface Parking {

    public Ticket park(Vehicle vehicle) throws ParkingFullException;

    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException;

}