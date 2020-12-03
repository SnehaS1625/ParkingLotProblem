package com.vapasi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerTest {

    private Owner owner;

    @BeforeEach
    public void setUp(){
        owner = new Owner();
    }

    @Test
    public void shouldReturnNotificationToOwner() {
    owner.notifyParkingLotStatus(Sign.generateFullSign());
    assertEquals(Sign.generateFullSign(), owner.parkingStatus());

    }

}
