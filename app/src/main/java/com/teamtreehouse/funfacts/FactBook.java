package com.teamtreehouse.funfacts;

import android.content.Context;

public class FactBook extends RandomSelector {

    private final String[] mFacts;

    public FactBook(Context context) {
        // Facts are now stored in a string array resource
        // This allows devs to easily add new facts and also can easily provide translations
        mFacts = context.getResources().getStringArray(R.array.facts);
    }

    @Override
    public String get() {
        // Randomly select a fact
        // Minimised code
        return mFacts[getRandomInt(mFacts.length)];
    }
}
