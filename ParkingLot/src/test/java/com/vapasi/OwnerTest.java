package com.vapasi;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerTest {

    private Owner owner;

    @BeforeEach
    public void setUp(){
        owner = new Owner();
    }

    public void shouldReturnNotificationToOwner() {
    boolean flag = owner.notifyIfParkingFull(true);
    assertTrue(flag);

    }

}
