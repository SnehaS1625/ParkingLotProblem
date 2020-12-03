package com.vapasi;

public class Person {

    Sign parkingStatus = Sign.generateNotFullSign();

    public void notifyParkingLotStatus(Sign parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public Sign parkingStatus() {
        return parkingStatus;
    }
}

