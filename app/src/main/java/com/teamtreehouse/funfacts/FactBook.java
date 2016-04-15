package com.teamtreehouse.funfacts;

import android.content.Context;

public class FactBook extends NonRepeatingRandomArraySelector<String> {

    Context mContext;

    public FactBook(Context context) {
        mContext = context;
    }

    @Override
    public String[] getArray() {
        // Facts are now stored in a string array resource
        // This allows devs to easily add new facts and also can easily provide translations
        return mContext.getResources().getStringArray(R.array.facts);
    }
}
