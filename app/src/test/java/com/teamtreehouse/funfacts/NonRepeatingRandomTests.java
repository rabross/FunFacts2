package com.teamtreehouse.funfacts;

import org.junit.Test;

import static org.junit.Assert.*;

public class NonRepeatingRandomTests {

    @Test
    public void NonRepeatingRandom_isNonRepeating() throws Exception {

        final int numberOfTries = Integer.MAX_VALUE;
        final int range = 10;
        int lastNumber = 1;

        NonRepeatingRandom nonRepeatingRandom = new NonRepeatingRandom();
        nonRepeatingRandom.setLastRandomInt(lastNumber);

        for (int i = 0; i < numberOfTries; i++) {
            int number = nonRepeatingRandom.nextInt(range);
            assertNotEquals(lastNumber, number);
            lastNumber = number;
        }
    }
}