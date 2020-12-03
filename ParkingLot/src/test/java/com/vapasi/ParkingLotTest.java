package com.vapasi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private static ParkingLot parkingLot;
    private Object firstCar = new Object();
    private Object secondCar = new Object();
    private Object thirdCar = new Object();
    private Object firstToken;
    private Object secondToken;
    List<Person> relatedPerson = new ArrayList<>();

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

        assertThrows(InvalidTokenException.class , () -> parkingLot.unPark(secondToken));
    }

    @Test
    public void shouldThrowOutOfSpaceExceptionWhenParkingLotIsFull(){
        firstToken = parkingLot.park(firstCar);
        secondToken = parkingLot.park(secondCar);
        assertThrows(OutOfSpaceException.class , () -> parkingLot.park(thirdCar));
    }

    @Test
    public void shouldReturnSignForOwnerWhenParkingIsFull() {
        Person owner = new Owner();
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);

        Sign parkingSign = owner.parkingStatus;
        Sign fullSign = Sign.generateFullSign();
        assertEquals(fullSign,parkingSign);
    }

    @Test
    public void shouldReturnSignForAttenderWhenParkingIsFull() {
        Person attender = new Attender();
        relatedPerson.add(attender);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);

        Sign parkingSign = attender.parkingStatus;
        Sign fullSign = Sign.generateFullSign();
        assertEquals(fullSign,parkingSign);
    }

    @Test
    public void shouldReturnSignForOwnerAndAttenderWhenParkingIsFull() {
        Person owner = new Owner();
        Person attender = new Attender();
        relatedPerson.add(attender);
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        parkingLot.park(secondCar);
        Sign fullSign = Sign.generateFullSign();

        Sign parkingSign = owner.parkingStatus;
        assertEquals(fullSign,parkingSign);

        parkingSign = attender.parkingStatus;
        assertEquals(fullSign,parkingSign);
    }

    @Test
    public void shouldNotReturnSignForOwnerAndAttenderWhenParkingIsFull() {
        Person owner = new Owner();
        Person attender = new Attender();
        relatedPerson.add(attender);
        relatedPerson.add(owner);
        parkingLot = new ParkingLot(relatedPerson);

        parkingLot.park(firstCar);
        Sign fullSign = Sign.generateFullSign();

        Sign parkingSign = owner.parkingStatus;
        assertNotEquals(fullSign,parkingSign);

        parkingSign = attender.parkingStatus;
        assertNotEquals(fullSign,parkingSign);
    }

}
