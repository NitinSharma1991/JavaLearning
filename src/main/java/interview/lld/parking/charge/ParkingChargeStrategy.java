package interview.lld.parking.charge;

public interface ParkingChargeStrategy {
    int getCharge(int parkHours);
}