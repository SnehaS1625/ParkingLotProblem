package com.vapasi;

public class Attender implements Collaborator {

    private boolean isNotified = false;

    @Override
    public void notifyParkingStatus() {
        this.isNotified = true;
    }

    public boolean isNotified() {
        return isNotified;
    }
}
