package interview.lld.parking;

import java.time.LocalDateTime;

public class Ticket {

    String vehicleNumber;
    int slotNumber;
    LocalDateTime localDateTime;
    VehicleType vehicleType;

    public Ticket(String vehicleNumber, int slotNumber, LocalDateTime localDateTime, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.slotNumber = slotNumber;
        this.localDateTime = localDateTime;
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "Ticket [slotNumber=" + slotNumber + ", vehicleNumber=" + vehicleNumber + ", date=" + localDateTime
                + ", vehicleSize=" + vehicleType + "]";
    }

}
