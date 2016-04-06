package com.teamtreehouse.funfacts;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class FunFactsActivity extends Activity {

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
        changeFact();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFact();
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }

    private void changeFact(){

        String fact = mFactBook.getFact();
        mFactLabel.setText(fact);

        int color = mColorWheel.getColor();
        mRelativeLayout.setBackgroundColor(color);
        mShowFactButton.setTextColor(color);

        // The setStatusBarColor is only available in Lollipop and newer
        // so we can do a check to only run this on >= Lollipop devices
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(color);
        }
    }
}
