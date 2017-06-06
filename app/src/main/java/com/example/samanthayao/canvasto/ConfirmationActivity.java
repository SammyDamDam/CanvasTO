package com.example.samanthayao.canvasto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 2 on 6/5/2017.
 */

public class ConfirmationActivity extends AppCompatActivity {

    Button mYes;
    Button mNo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation_build);

        mYes = (Button) findViewById(R.id.yesBtn);
        mNo = (Button) findViewById(R.id.noBtn);

        final long price = getIntent().getIntExtra("building_cost",-1);
        String type = getIntent().getStringExtra("housing_type");

        TextView txtLabel = (TextView)findViewById(R.id.confirmation_text);
        txtLabel.setText("You are purchasing " + type + " for " + price + " dollars. Will you proceed with the transaction?");

        mYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TorontoActivity.treasury = TorontoActivity.treasury - price;
                //Somehow get this pop up to close without resetting all the values.
            }
        });

        mNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //program the page to get back to TorontoActivity without resetting everything
            }
        })

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.6),(int)(height*0.45));
    }
}
