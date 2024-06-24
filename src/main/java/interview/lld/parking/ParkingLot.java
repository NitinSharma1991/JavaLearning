package interview.lld.parking;

import interview.lld.parking.charge.ParkingChargeStrategy;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ParkingLot implements Parking {
    private static volatile ParkingLot parkingLot;
    private final List<Slot> twoWheelerSlots;
    private final List<Slot> fourWheelerSlots;

    private ParkingLot() {
        this.twoWheelerSlots = new ArrayList<>();
        this.fourWheelerSlots = new ArrayList<>();
    }

    public static ParkingLot getParkingLot() {
        if (parkingLot == null) {
            synchronized (ParkingLot.class) {
                if (parkingLot == null) {
                    parkingLot = new ParkingLot();
                }
            }
        }

        return parkingLot;
    }

    public void initializeParkingSlots(int numberOfTwoWheelerParkingSlots, int numberOfFourWheelerParkingSlots) {

        for (int i = 1; i <= numberOfTwoWheelerParkingSlots; i++) {
            twoWheelerSlots.add(new Slot(i));
        }

        System.out.printf("Created a two wheeler parking lot with %s slots %n", numberOfTwoWheelerParkingSlots);

        for (int i = 1; i <= numberOfFourWheelerParkingSlots; i++) {
            fourWheelerSlots.add(new Slot(i));
        }

        System.out.printf("Created a four wheeler parking lot with %s slots %n", numberOfFourWheelerParkingSlots);
    }

    @Override
    public Ticket park(Vehicle vehicle) throws ParkingFullException {
        Slot nextAvailableSlot;
        if (vehicle.vehicleType().equals(VehicleType.FOUR_WHEELER_VEHICLE)) {
            nextAvailableSlot = getNextAvailableFourWheelerSlot();
        } else {
            nextAvailableSlot = getNextAvailableTwoWheelerSlot();
        }
        nextAvailableSlot.occupySlot(vehicle);
        System.out.printf("Allocated slot number: %d \n", nextAvailableSlot.getSlotNumber());
        return new Ticket(vehicle.vehicleNumber(), nextAvailableSlot.getSlotNumber(),
                LocalDateTime.now(), vehicle.vehicleType());
    }

    @Override
    public int unPark(Ticket ticket, ParkingChargeStrategy parkingCostStrategy) throws InvalidVehicleNumberException {
        int costByHours;
        Slot slot;
        try {
            if (ticket.vehicleType().equals(VehicleType.FOUR_WHEELER_VEHICLE)) {
                slot = getFourWheelerSlotByVehicleNumber(ticket.vehicleNumber());
            } else {
                slot = getTwoWheelerSlotByVehicleNumber(ticket.vehicleNumber());
            }
            slot.unOccupySlot();
            int hours = getHoursParked(ticket.localDateTime(), LocalDateTime.now());
            costByHours = parkingCostStrategy.getCharge(hours);
            System.out.println(
                    "Vehicle with registration " + ticket.vehicleNumber() + " at slot number " + slot.getSlotNumber()
                            + " was parked for " + hours + " hours and the total charge is " + costByHours);
        } catch (InvalidVehicleNumberException invalidVehicleNumber) {
            System.out.println(invalidVehicleNumber.getMessage());
            throw invalidVehicleNumber;
        }
        return costByHours;
    }

    private int getHoursParked(LocalDateTime startDate, LocalDateTime endDate) {
        long hours = Duration.between(startDate, endDate).toHours();
        return (int) hours;

    }

    private Slot getFourWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
        for (Slot slot : fourWheelerSlots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null && vehicle.vehicleNumber().equals(vehicleNumber)) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Four wheeler with registration number " + vehicleNumber + " not found");
    }

    private Slot getTwoWheelerSlotByVehicleNumber(String vehicleNumber) throws InvalidVehicleNumberException {
        for (Slot slot : twoWheelerSlots) {
            Vehicle vehicle = slot.getVehicle();
            if (vehicle != null && vehicle.vehicleNumber().equals(vehicleNumber)) {
                return slot;
            }
        }
        throw new InvalidVehicleNumberException("Two wheeler with registration number " + vehicleNumber + " not found");
    }

    private Slot getNextAvailableFourWheelerSlot() throws ParkingFullException {
        for (Slot slot : fourWheelerSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }

    private Slot getNextAvailableTwoWheelerSlot() throws ParkingFullException {
        for (Slot slot : twoWheelerSlots) {
            if (slot.isEmpty()) {
                return slot;
            }
        }
        throw new ParkingFullException("No Empty Slot available");
    }
}
