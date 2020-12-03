package com.vapasi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private static ParkingLot parkingLot;
    List<Collaborator> relatedPerson = new ArrayList<>();
    private Object firstCar = new Object();
    private Object secondCar = new Object();
    private Object thirdCar = new Object();
    private Object firstToken;
    private Object secondToken;

    @BeforeEach
    public void setup() {
        parkingLot = new ParkingLot(relatedPerson);

    }

    @Test
    public void shouldParkMyCarAndCheckIfParkedOrNot() {
        firstToken = parkingLot.park(firstCar);
        assertTrue(parkingLot.isParked(firstCar));
    }

    @Test
    public void shouldUnParkMyCar() {
        firstToken = parkingLot.park(firstCar);

        Object unpackedCar = parkingLot.unPark(firstToken);

        assertFalse(parkingLot.isParked(unpackedCar));

    }

    @Test
    public void shouldThrowExceptionWhenUnParkUsedInvalidToken() {
        firstToken = parkingLot.park(firstCar);

        assertThrows(InvalidTokenException.class, () -> parkingLot.unPark(secondToken));
    }

    @Test
    public void shouldThrowOutOfSpaceExceptionWhenParkingLotIsFull() {
        firstToken = parkingLot.park(firstCar);
        secondToken = parkingLot.park(secondCar);
        assertThrows(OutOfSpaceException.class, () -> parkingLot.park(thirdCar));
    }

    @Test
    public void shouldReturnSignForOwnerWhenParkingIsFull() {
        Collaborator owner = new Owner();
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);

        boolean parkingSign = owner.isNotifiedForParkingFull();
        assertTrue(parkingSign);
    }

    @Test
    public void shouldReturnSignForAttenderWhenParkingIsFull() {
        Collaborator attender = new Attender();
        relatedPerson.add(attender);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);

        boolean parkingSign = attender.isNotifiedForParkingFull();
        assertTrue(parkingSign);
    }

    @Test
    public void shouldReturnSignForOwnerAndAttenderWhenParkingIsFull() {
        Collaborator owner = new Owner();
        Collaborator attender = new Attender();
        relatedPerson.add(attender);
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);

        boolean parkingSign = owner.isNotifiedForParkingFull();
        assertTrue(parkingSign);

        parkingSign = attender.isNotifiedForParkingFull();
        assertTrue(parkingSign);
    }

    @Test
    public void shouldNotReturnSignForOwnerAndAttenderWhenParkingIsFull() {
        Collaborator owner = new Owner();
        Collaborator attender = new Attender();
        relatedPerson.add(attender);
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);

        boolean parkingSign = owner.isNotifiedForParkingFull();
        assertFalse(parkingSign);

        parkingSign = attender.isNotifiedForParkingFull();
        assertFalse(parkingSign);
    }

    @Test
    public void shouldNotifyWhenParkingIsAvailable() {
        Collaborator owner = new Owner();
        Collaborator attender = new Attender();
        relatedPerson.add(attender);
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        firstToken = parkingLot.park(firstCar);
        secondToken = parkingLot.park(secondCar);

        boolean parkingSign = owner.isNotifiedForParkingFull();
        assertTrue(parkingSign);
        parkingLot.unPark(firstToken);

        parkingSign = ((Owner) owner).isNotifiedForParkingAvailable();
        assertTrue(parkingSign);

    }

}
