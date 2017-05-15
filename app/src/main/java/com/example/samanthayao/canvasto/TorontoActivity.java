package com.example.samanthayao.canvasto;

import android.os.Bundle;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

        mA1 = (Button) findViewById(R.id.a1);
        mA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu optionsA1 = new PopupMenu(TorontoActivity.this, mA1);
                optionsA1.getMenuInflater().inflate(R.menu.popup_menu, optionsA1.getMenu());

                optionsA1.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                TorontoActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                optionsA1.show();
            }
        });

        mA2 = (Button) findViewById(R.id.a2);
        mA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu optionsA2 = new PopupMenu(TorontoActivity.this, mA2);
                optionsA2.getMenuInflater().inflate(R.menu.popup_menu, optionsA2.getMenu());

                optionsA2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                TorontoActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                optionsA2.show();
            }
        });

        mA3 = (Button) findViewById(R.id.a3);
        mA3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu optionsA2 = new PopupMenu(TorontoActivity.this, mA2);
                optionsA2.getMenuInflater().inflate(R.menu.popup_menu, optionsA2.getMenu());

                optionsA2.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(
                                TorontoActivity.this,
                                "You Clicked : " + item.getTitle(),
                                Toast.LENGTH_SHORT
                        ).show();
                        return true;
                    }
                });
                optionsA2.show();
            }
        });
    }
}
