package com.vapasi;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private final int MAX_SIZE_OF_PARKINGLOT = 2;
    private Sign fullSign = Sign.generateFullSign();
    private Sign notFullSign = Sign.generateNotFullSign();
    private Owner owner;

    Map<Object, Object> parkingSlots = new HashMap<>();

    public ParkingLot(Owner owner)  {
        this.owner = owner;
    }

    public ParkingLot()  {

    }


    public Object park(Object car) {
        if(isFull().equals(fullSign))
            throw new OutOfSpaceException("Parking Lot Is Full");
        Object token = new Object();
        parkingSlots.put(token, car);
        if(isFull().equals(fullSign))
            owner.notifyParkingLotStatus(fullSign);
        return token;
    }

    public boolean isParked(Object car) {
        return parkingSlots.containsValue(car);
    }

    public Object unPark(Object token) {
        if(token == null) {
            throw new InvalidTokenException("Please enter valid exception");
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
