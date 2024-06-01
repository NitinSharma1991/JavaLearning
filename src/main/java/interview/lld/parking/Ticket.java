package interview.lld.parking;

import java.time.LocalDateTime;


public record Ticket(String vehicleNumber, int slotNumber, LocalDateTime localDateTime, VehicleType vehicleType) {


    @Override
    public String toString() {
        return "Ticket [slotNumber=" + slotNumber + ", vehicleNumber=" + vehicleNumber + ", date=" + localDateTime
                + ", vehicleSize=" + vehicleType + "]";
    }

}
