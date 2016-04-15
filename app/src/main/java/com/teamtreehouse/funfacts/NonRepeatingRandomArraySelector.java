package com.teamtreehouse.funfacts;

/**
 * Abstract class for random selectors
 *
 * Created by robertross on 22/03/16.
 */
public abstract class NonRepeatingRandomArraySelector<T> implements ArraySelector<T>, RandomSelector<T> {

    private NonRepeatingRandom mRandomGenerator = new NonRepeatingRandom();

    public int getLastIndex(){
        return mRandomGenerator.getLastRandomInt();
    }

    @Override
    public T get() {

        T[] array = getArray();

        // Randomly select a fact
        // Minimised code
        return array[mRandomGenerator.nextInt((array.length))];
    }

    @Override
    public T get(int index) {

        T[] array = getArray();

        // Sanitise input no if statement style
        index = (index >= array.length) ? array.length - 1 : (index < 0 ? 0 : index);
        mRandomGenerator.setLastRandomInt(index);
        return array[index];
    }
}
