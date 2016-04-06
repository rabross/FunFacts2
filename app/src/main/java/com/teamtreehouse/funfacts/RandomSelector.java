package com.teamtreehouse.funfacts;

/**
 * Abstract class for random selectors
 *
 * Created by robertross on 22/03/16.
 */
public abstract class RandomSelector {

    private NonRepeatingRandom mRandomGenerator = new NonRepeatingRandom();

    public int getRandomInt(int n){
        return mRandomGenerator.nextInt(n);
    }

    public abstract Object get();
}
