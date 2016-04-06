package com.teamtreehouse.funfacts;

import java.util.Random;

/**
 * Helper class that generates a non-repeating random int.
 *
 * Created by robertross on 22/03/16.
 */
public class NonRepeatingRandom extends Random {

    private int mLastRandomInt = -1;

    @Override
    public int nextInt(int n) {

        // Here we use recursion to get a non-repeating random number
        int random = super.nextInt(n);
        return mLastRandomInt = (random == mLastRandomInt ? nextInt(n) : random);
    }
}
