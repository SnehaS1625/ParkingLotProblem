package com.vapasi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {

    private final int MAX_SIZE_OF_PARKINGLOT = 2;
    private Sign fullSign = Sign.generateFullSign();
    private Sign notFullSign = Sign.generateNotFullSign();
    private Owner owner;
    private boolean isLotFull;

    List<Person> relatedPersons = new ArrayList<>();
    Map<Object, Object> parkingSlots = new HashMap<>();

    public ParkingLot(List<Person> relatedPersons)  {
        this.relatedPersons = relatedPersons;
    }

    public Object park(Object car) {
        if(isFull().equals(fullSign))
            throw new OutOfSpaceException("Parking Lot Is Full");
        Object token = new Object();
        parkingSlots.put(token, car);
        if(isFull().equals(fullSign))
            relatedPersons.stream().forEach(person -> person.notifyParkingLotStatus(fullSign));
        return token;
    }

    public boolean isParked(Object car) {
        return parkingSlots.containsValue(car);
    }

    public Object unPark(Object token) {
        if(!parkingSlots.containsKey(token)) {
            throw new InvalidTokenException("Invalid token");
        }
        Object car = parkingSlots.get(token);
        parkingSlots.remove(token);
        return car;
    }

    public Sign isFull() {
        if(parkingSlots.size() == MAX_SIZE_OF_PARKINGLOT)
            return fullSign;
        return notFullSign;
    }

}
