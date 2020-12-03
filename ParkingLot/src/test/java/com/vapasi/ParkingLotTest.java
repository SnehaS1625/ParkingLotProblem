package com.vapasi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    private static ParkingLot parkingLot;
    private Object firstCar = new Object();
    private Object secondCar = new Object();
    private Object thirdCar = new Object();
    private Object firstToken;
    private Object secondToken;

    @BeforeEach
    public void setup() {
        parkingLot = new ParkingLot();
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

   /* @Test
    public void shouldReturnSignWhenParkingIsFull() {
        Sign parkingSign = parkingLot.isFull();
        Sign fullSign = Sign.generateFullSign();
        assertNotEquals(fullSign,parkingSign);

        parkingLot.park(firstCar);
        parkingSign = parkingLot.isFull();
        assertNotEquals(fullSign,parkingSign);

        parkingLot.park(secondCar);
        parkingSign = parkingLot.isFull();
        assertEquals(fullSign,parkingSign);

        assertThrows(OutOfSpaceException.class , () -> parkingLot.park(thirdCar));
    }*/

    @Test
    public void shouldReturnSignWhenParkingIsFull() {



    }



}
