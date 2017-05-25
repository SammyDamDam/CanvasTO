package com.example.samanthayao.canvasto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

/**
 * Created by Samantha Yao on 5/25/2017.
 */

public class BuildActivity extends AppCompatActivity {

    Button mresidentialBtn;
    Button meducationBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_build);

        mresidentialBtn = (Button) findViewById(R.id.residentialBtn);
        meducationBtn = (Button) findViewById(R.id.educationBtn);

    }
}
