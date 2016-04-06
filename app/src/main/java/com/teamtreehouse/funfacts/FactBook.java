package com.teamtreehouse.funfacts;

import android.content.Context;

import java.util.Random;

public class FactBook {

    private final String[] mFacts;

    public FactBook(Context context) {
        // Facts are now stored in a string array resource
        // This allows devs to easily add new facts and also can easily provide translations
        mFacts = context.getResources().getStringArray(R.array.facts);
    }

    // Method (abilities: things the object can do)
    public String getFact() {
        String fact = "";

        // Randomly select a fact
        Random randomGenerator = new Random(); // Construct a new Random number generator
        int randomNumber = randomGenerator.nextInt(mFacts.length);

        fact = mFacts[randomNumber];

        return fact;
    }
}