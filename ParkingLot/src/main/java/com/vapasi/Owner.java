package com.vapasi;

public class Owner implements Collaborator {

    private boolean isNotifiedParkingFull = false;

    @Override
    public void notifyParkingFullStatus() {
        this.isNotifiedParkingFull = true;
    }

    public void notifyParkingAvailable() {
        isNotifiedParkingFull = false;
    }

    public boolean isNotifiedForParkingFull() {
        return isNotifiedParkingFull;
    }

    public boolean isNotifiedForParkingAvailable() {
        return !isNotifiedParkingFull;
    }
}
