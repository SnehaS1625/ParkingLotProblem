package com.vapasi;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private static int MAX_SIZE_OF_PARKINGLOT = 2;

    static Map<Object, Object> parkingSlots = new HashMap<>();

    public Object park(Object car) {
        if(parkingSlots.size() == MAX_SIZE_OF_PARKINGLOT)
            throw new OutOfSpaceException("Parking Lot Is Full");
        Object token = new Object();
        parkingSlots.put(token, car);
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

}
