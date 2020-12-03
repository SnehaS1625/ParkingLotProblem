package com.vapasi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private final int MAX_SIZE_OF_PARKINGLOT = 2;
    List<Collaborator> relatedPersons = new ArrayList<>();
    Map<Object, Object> parkingSlots = new HashMap<>();
    private boolean fullSign = true;
    private boolean notFullSign = false;
    private Owner owner;
    private boolean isLotFull;

    public ParkingLot(List<Collaborator> relatedPersons) {
        this.relatedPersons = relatedPersons;
    }

    public Object park(Object car) {
        if (isFull())
            throw new OutOfSpaceException("Parking Lot Is Full");
        Object token = new Object();
        parkingSlots.put(token, car);
        if (isFull())
            relatedPersons.stream().forEach(collaborator -> collaborator.notifyParkingFullStatus());
        return token;
    }

    public boolean isParked(Object car) {
        return parkingSlots.containsValue(car);
    }

    public Object unPark(Object token) {
        if (!parkingSlots.containsKey(token)) {
            throw new InvalidTokenException("Invalid token");
        }
        Object car = parkingSlots.get(token);
        parkingSlots.remove(token);
        relatedPersons.stream().filter(i -> i.getClass() == Owner.class).forEach(i -> {
            Owner j = (Owner) i;
            j.notifyParkingAvailable();
        });
        return car;
    }

    public boolean isFull() {
        if (parkingSlots.size() == MAX_SIZE_OF_PARKINGLOT)
            return fullSign;
        return notFullSign;
    }

}
