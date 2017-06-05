package com.example.samanthayao.canvasto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.samanthayao.canvasto.R.id.buildBtn;
import static com.example.samanthayao.canvasto.R.id.manageBtn;

/**
 * Created by wenwi on 5/29/2017.
 */

public class HousingActivity extends AppCompatActivity{
    Button mDetached;
    Button mTownhouse;
    Button mSemiDetached;
    Button mCondo;
    public int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_housing);

        mDetached = (Button) findViewById(R.id.purchaseDetached);
        mTownhouse = (Button) findViewById(R.id.purchaseTownhouse);
        mSemiDetached = (Button) findViewById(R.id.purchaseSemiDetached);
        mCondo = (Button) findViewById(R.id.purchaseCondo);

        mDetached.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = price + 10000;
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));
    }

    @Override
    public void onBackPressed(){
        Intent i = new Intent();
        i.putExtra("message",)
    }



}
