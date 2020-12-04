package com.vapasi;

public class Owner implements Collaborator {

    private boolean isNotifiedParkingFull = false;
    private boolean isNotifiedParkingAvailable = false;
    @Override
    public void notifyParkingFullStatus() {
        this.isNotifiedParkingFull = true;
    }

    public void notifyParkingAvailable() {
        isNotifiedParkingAvailable = true;
    }

    public boolean isNotifiedForParkingFull() {
        return isNotifiedParkingFull;
    }

    public boolean isNotifiedForParkingAvailable() {
        return isNotifiedParkingAvailable;
    }
}
