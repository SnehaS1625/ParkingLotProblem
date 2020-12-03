package com.vapasi;

public class Attender implements Collaborator {

    private boolean isNotified = false;

    @Override
    public void notifyParkingFullStatus() {
        this.isNotified = true;
    }

    public boolean isNotifiedForParkingFull() {
        return isNotified;

    }
}
