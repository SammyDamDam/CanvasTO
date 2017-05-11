package com.example.samanthayao.canvasto;

import android.os.Bundle;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

/**
 * Created by Samantha Yao on 5/10/2017.
 */

public class TorontoActivity extends AppCompatActivity {

    Button mA1,mA2,mA3,mA4,mA5;
    Button mB1,mB2,mB3,mB4,mB5;
    Button mC1,mC2,mC3,mC4,mC5;
    Button mD1,mD2,mD3,mD4,mD5;
    Button mE1,mE2,mE3,mE4,mE5;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toronto);

        public void showPopup(View v) {
            PopupMenu popup = new PopupMenu(this, v);
            MenuInflater inflater = popup.getMenuInflater();
            inflater.inflate(R.menu.actions, popup.getMenu());
            popup.show();
        }
    }
}
