package com.vapasi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OwnerTest {

    private Owner owner;

    @BeforeEach
    public void setUp() {
        owner = new Owner();
    }

    @Test
    public void shouldReturnNotificationToOwnerIfParkingLotIsFull() {
        owner.notifyParkingFullStatus();
        assertTrue(owner.isNotifiedForParkingFull());

    }
    @Test
    public void shouldReturnNotificationToOwnerIfParkingLotIsAvailable() {
        owner.notifyParkingAvailable();
        assertTrue(owner.isNotifiedForParkingAvailable());

    }

}
