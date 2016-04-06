package com.teamtreehouse.funfacts;

import android.content.Context;
import android.graphics.Color;

import java.util.Random;

public class ColorWheel {

    private final int[] mColors;

    public ColorWheel(Context context) {
        // Colors are now stored as color resources but referred to using an int array resource
        // so they can be randomly selected
        mColors = context.getResources().getIntArray(R.array.colors);
    }

    // Method (abilities: things the object can do)
    public int getColor() {

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mColors.length);

        return mColors[randomNumber];
    }
}
