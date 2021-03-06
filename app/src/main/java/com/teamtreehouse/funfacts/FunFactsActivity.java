package com.teamtreehouse.funfacts;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {

    public static final String TAG = FunFactsActivity.class.getSimpleName();
    private static final String KEY_FACT_SEED = "fact_seed";
    private static final String KEY_COLOR_SEED = "color_seed";

    private TextView mFactLabel;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private FactBook mFactBook;
    private ColorWheel mColorWheel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Declare our View variables and assign them the Views from the layout file
        mFactLabel = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);

        mFactBook = new FactBook(this);
        mColorWheel = new ColorWheel(this);

        //This allows us to always have a random initial fact
        if (savedInstanceState == null)
            changeFact();
        else {
            changeFact(mFactBook.get(savedInstanceState.getInt(KEY_FACT_SEED)),
                    mColorWheel.get(savedInstanceState.getInt(KEY_COLOR_SEED)));
        }

        mShowFactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFact();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putInt(KEY_FACT_SEED, mFactBook.getLastIndex());
        outState.putInt(KEY_COLOR_SEED, mColorWheel.getLastIndex());
        super.onSaveInstanceState(outState);
    }

    private void changeFact(){
        changeFact(mFactBook.get(), mColorWheel.get());
    }

    @SuppressWarnings("ResourceAsColor")
    private void changeFact(String fact, int color) {

        mFactLabel.setText(fact);
        mRelativeLayout.setBackgroundColor(color);
        mShowFactButton.setTextColor(color);

        // The setStatusBarColor is only available in Lollipop and newer
        // so we can do a check to only run this on >= Lollipop devices
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
        }

        //Print fact and color in logcat
        Log.d(TAG, fact + String.format(" #%06x", (0xFFFFFF & color)));
    }
}
