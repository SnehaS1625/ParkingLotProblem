package com.vapasi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class SignTest {

    @Test
    public void shouldReturnFalseIfOneObjectIsNull(){
        Sign firstSign = Sign.generateFullSign();
        Sign secondSign = null;
        assertFalse(firstSign.equals(secondSign));
    }

    @Test
    public void shouldReturnNotEqualIfTwoObjectsAreDifferent(){
        Sign firstSign = Sign.generateFullSign();
        Sign secondSign = Sign.generateNotFullSign();
        assertFalse(firstSign.equals(secondSign));
    }


}
