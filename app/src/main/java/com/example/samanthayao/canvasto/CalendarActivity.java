package com.example.samanthayao.canvasto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Samantha Yao on 6/2/2017.
 */

public class CalendarActivity extends AppCompatActivity{

    public static final String JSON_URL = "http://app.toronto.ca/cc_sr_v1_app/data/edc_eventcal_APR?limit=500";
    private ListView listview;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        listview = (ListView) findViewById(R.id.calendarList);

        sendRequest();

    }

    private void sendRequest(){
        StringRequest stringRequest = new StringRequest(JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        showJSON(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(CalendarActivity.this,error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

    }

    private void showJSON(String json){
        JSONParser pj = new JSONParser(json);
        pj.parseJSON();
        CustomList lv = new CustomList(this, JSONParser.orgType);
        listview.setAdapter(lv);

    }
}
