package com.vapasi;

public class Owner {

     Sign parkingStatus = Sign.generateNotFullSign();

    public void notifyParkingLotStatus(Sign parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public Sign parkingStatus() {
        return parkingStatus;
    }
}
