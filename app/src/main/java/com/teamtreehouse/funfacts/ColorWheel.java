package com.teamtreehouse.funfacts;

import android.content.Context;

public class ColorWheel extends RandomSelector {

    private final int[] mColors;

    public ColorWheel(Context context) {
        // Colors are now stored as color resources but referred to using an int array resource
        // so they can be randomly selected
        mColors = context.getResources().getIntArray(R.array.colors);
    }

    @Override
    public Integer get() {
        // Randomly select a color
        // Minimised code
        return mColors[getRandomInt(mColors.length)];
    }
}
