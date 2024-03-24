package interview.lld.parking;

public class Slot {

    Vehicle vehicle;
    boolean isEmpty;
    int slotNumber;

    public Slot(int slotNumber) {
        this.slotNumber = slotNumber;
        isEmpty = true;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }


    public int getSlotNumber() {
        return slotNumber;
    }

    public void occupySlot(Vehicle vehicle){
        this.setVehicle(vehicle);
        this.isEmpty = false;
    }


    public void unOccupySlot(){
        this.setVehicle(null);
        this.isEmpty = true;
    }


}
