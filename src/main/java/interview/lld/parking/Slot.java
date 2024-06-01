package interview.lld.parking;

import lombok.Getter;
import lombok.Setter;

public class Slot {

    @Setter
    @Getter
    Vehicle vehicle;
    boolean isEmpty;
    @Getter
    int slotNumber;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }


    public void occupySlot(Vehicle vehicle) {
        this.setVehicle(vehicle);
        this.isEmpty = false;
    }


    public void unOccupySlot() {
        this.setVehicle(null);
        this.isEmpty = true;
    }


}
