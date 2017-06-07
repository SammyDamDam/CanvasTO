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

    public static float treasury = (float) 1000.0;
    TextView mtreasuryValue;
    private GridView gv;
    Handler handler;
    int population = 1000;
    float incomeTax = (float) 0.11;
    float avgIncomePerDay = (float) 952/7;
    TextView mpopulationValue;
    Button mjsonData;


    //List of the images to put into the GridView
    int[] imageIDs = {
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.oldcityhall,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
            R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,R.drawable.grass,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toronto);

        //creating a Handler that runs every 2 seconds to update things e.g. treasury, population
        handler = new Handler();
        mtreasuryValue = (TextView) findViewById(R.id.treasuryValue);
        mpopulationValue = (TextView) findViewById(R.id.populationValue);

        Runnable updateTreasury = new Runnable(){
            @Override
            public void run()
            {
                //TODO insert what to do every 5 seconds
                population++;
                treasury+=population*0.74*avgIncomePerDay*incomeTax;

                mpopulationValue.setText(String.valueOf(population));
                mtreasuryValue.setText(String.valueOf(treasury));
                handler.postDelayed(this,60000); //2000 milliseconds = 2 seconds, can be changed
            }
        };

        handler.postDelayed(updateTreasury,60000); //repeats Handler every 2 seconds

        gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new GridViewAdapter(this,imageIDs));

        //TODO code what happens when items on the GridView are clicked
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                PopupMenu options = new PopupMenu(TorontoActivity.this, v);
                options.getMenuInflater().inflate(R.menu.popup_menu, options.getMenu());

                options.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case buildBtn:
                                //Opens BuildActivity when the Build option is clicked
                                startActivity(new Intent(TorontoActivity.this,BuildActivity.class));
                                break;
                            case manageBtn:
                                //ManageActivity has not been created yet
                                //Toast.makeText(TorontoActivity.this,ManageActivity.class));
                                break;
                            default:
                                //idk how to implement the sell stuff
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



        mjsonData = (Button) findViewById(R.id.jsonBtn);
        mjsonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TorontoActivity.this,CalendarActivity.class);
                TorontoActivity.this.startActivity(intent);
            }
        });
    }
}





