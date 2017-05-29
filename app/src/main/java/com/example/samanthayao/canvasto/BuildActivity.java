package com.example.samanthayao.canvasto;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static com.example.samanthayao.canvasto.R.id.buildBtn;
import static com.example.samanthayao.canvasto.R.id.manageBtn;

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
        mresidentialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu options = new PopupMenu(BuildActivity.this, v);
                options.getMenuInflater().inflate(R.menu.popup_menu, options.getMenu());

                options.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case buildBtn:
                                //insert stuff
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
        meducationBtn = (Button) findViewById(R.id.educationBtn);

    }
}
