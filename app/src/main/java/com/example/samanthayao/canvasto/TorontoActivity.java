package com.example.samanthayao.canvasto;

import android.os.Bundle;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
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

/**
 * Created by Samantha Yao on 5/10/2017.
 */

public class TorontoActivity extends AppCompatActivity {

    Timer treasuryTimer;
    TimerTask updateTreasuryTimer;
    int treasury;
    TextView mtreasuryValue;
    GridView gv;
    String[] plots = new String[]{
            "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4","B5",
            "C1","C2","C3","C4","C5","D1","D2","D3","D4","D5",
            "E1","E2","E3","E4","E5"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toronto);

        gv = (GridView) findViewById(R.id.gv);

        final List<String> landPlots = new ArrayList<String>(Arrays.asList(plots));

        // Create a new ArrayAdapter
        final ArrayAdapter<String> gridViewArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, landPlots);

        // Data bind GridView with ArrayAdapter (String Array elements)
        gv.setAdapter(gridViewArrayAdapter);

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                PopupMenu optionsA1 = new PopupMenu(TorontoActivity.this, v);
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

        mtreasuryValue = (TextView) findViewById(R.id.treasuryValue);
        treasury= 0;
        /*updateTreasuryTimer = new TimerTask(){
            @Override
            public void run(){
                treasury += 1000;

                mtreasuryValue.setText(treasury);
            }
        };
        treasuryTimer.schedule(updateTreasuryTimer,0,10000);*/

    }
}

