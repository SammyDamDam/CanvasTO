package com.example.samanthayao.canvasto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by wenwi on 5/29/2017.
 */

public class HousingActivity extends AppCompatActivity{
    Button mDetached;
    Button mTownhouse;
    Button mSemiDetached;
    Button mCondo;

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
                startActivity(new Intent(HousingActivity.this, HousingPop.class));

            }
        })


    }



}
