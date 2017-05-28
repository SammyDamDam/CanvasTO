package com.example.samanthayao.canvasto;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Build;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.samanthayao.canvasto.R.id.buildBtn;
import static com.example.samanthayao.canvasto.R.id.manageBtn;

/**
 * Created by Samantha Yao on 5/10/2017.
 */

public class TorontoActivity extends AppCompatActivity {

    int treasury = 0;
    TextView mtreasuryValue;
    private GridView gv;
    Handler handler;

    int[] imageIDs = {
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toronto);

        handler = new Handler();
        mtreasuryValue = (TextView) findViewById(R.id.treasuryValue);

        Runnable updateTreasury = new Runnable(){
            @Override
            public void run()
            {
                treasury++;
                mtreasuryValue.setText(String.valueOf(treasury));
                handler.postDelayed(this,2000);  // Run this again in 1 second
                // (i.e. we create an infinite loop that
                // executes every second)
            }
        };

        handler.postDelayed(updateTreasury,2000);

        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new GridViewAdapter(this,imageIDs));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                PopupMenu options = new PopupMenu(TorontoActivity.this, v);
                options.getMenuInflater().inflate(R.menu.popup_menu, options.getMenu());

                options.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case buildBtn:
                                Intent buildIntent = new Intent(TorontoActivity.this, BuildActivity.class);
                                TorontoActivity.this.startActivity(buildIntent);
                                break;
                            case manageBtn:
                                Toast.makeText(TorontoActivity.this, "manage", Toast.LENGTH_LONG);
                                break;
                            default:
                                Toast.makeText(TorontoActivity.this, "sell", Toast.LENGTH_LONG);
                                break;
                        }
                        return true;
                    }

                    ;
                });
                options.show();
            }
        });
    }
}





