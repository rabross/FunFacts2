package com.teamtreehouse.funfacts;

import android.content.Context;

import org.apache.commons.lang3.ArrayUtils;

public class ColorWheel extends NonRepeatingRandomArraySelector<Integer> {

    Context mContext;

    public ColorWheel (Context context) {
        mContext = context;
    }

    @Override
    public Integer[] getArray() {
        // Colors are now stored as color resources but referred to using an int array resource
        // so they can be randomly selected
        return ArrayUtils.toObject(mContext.getResources().getIntArray(R.array.colors));
    }
}
