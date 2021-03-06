package com.example.samanthayao.canvasto;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Samantha Yao on 6/2/2017.
 * Parses JSON data and displays it in a ListView
 */

public class CalendarActivity extends AppCompatActivity{

    ListView mcalendarList;
    // Will show the string "data" that holds the results
    TextView results;
    // URL of object to be parsed
    String JsonURL = "http://app.toronto.ca/cc_sr_v1_app/data/edc_eventcal_APR?limit=500.json";
    // This string will hold the results
    String data = "";
    // Defining the Volley request queue that handles the URL request concurrently
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        // Creates the Volley request queue
        requestQueue = Volley.newRequestQueue(this);

        // Casts results into the TextView found within the main layout XML with id jsonData
        mcalendarList = (ListView) findViewById(R.id.calendarList);
        final TextView textView = (TextView) findViewById(R.id.textView2);

        // Creating the JsonArrayRequest class called arrayreq, passing the required parameters
        //JsonURL is the URL to be fetched from
        JsonArrayRequest arrayreq = new JsonArrayRequest(JsonURL,
                // The second parameter Listener overrides the method onResponse() and passes
                //JSONArray as a parameter
                new Response.Listener<JSONArray>() {

                    // Takes the response from the JSON request
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            String[] data = new String[response.length()];
                            //TODO retrieve stuff from the JSON file
                            // Retrieves data from JSON Object 'eventName' for all events
                            for (int i = 0;i<response.length();i++){
                                JSONObject event = response.getJSONObject(i);
                                JSONObject calEvent = event.getJSONObject("calEvent");

                                String eventName = calEvent.getString("eventName");
                                data[i] = eventName;

                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(CalendarActivity.this,R.layout.activity_listview,data);
                            mcalendarList.setAdapter(adapter);


                        }
                        // Try and catch are included to handle any errors due to JSON
                        catch (JSONException e) {
                            // If an error occurs, this prints the error to the log
                            e.printStackTrace();
                        }
                    }
                },
                // The final parameter overrides the method onErrorResponse() and passes VolleyError
                //as a parameter
                new Response.ErrorListener() {
                    @Override
                    // Handles errors that occur due to Volley
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        // Adds the JSON array request "arrayreq" to the request queue
        requestQueue.add(arrayreq);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.8),(int)(height*0.6));
    }
}
