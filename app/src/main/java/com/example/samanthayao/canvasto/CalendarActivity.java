package com.example.samanthayao.canvasto;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Samantha Yao on 6/2/2017.
 */

public class CalendarActivity extends AppCompatActivity{

    // json object response url
    private String URL = "http://app.toronto.ca/cc_sr_v1_app/data/edc_eventcal_APR?limit=500";

    private static String TAG = CalendarActivity.class.getSimpleName();
    private Button mjsonRequestBtn;

    // Progress dialog
    private ProgressDialog pDialog;

    private TextView mjsonText;

    // temporary string to show the parsed response
    private String jsonResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        mjsonRequestBtn = (Button) findViewById(R.id.jsonRequestBtn);
        mjsonText = (TextView) findViewById(R.id.jsonText);

        pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);

        mjsonRequestBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // making json object request
                makeJsonArrayRequest();
            }
        });

    }

    /**
     * Method to make json object request where json response starts wtih {
     * */
    private void makeJsonArrayRequest() {

        showpDialog();

        JsonArrayRequest req = new JsonArrayRequest(URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        try {
                            // Parsing json array response
                            // loop through each json object
                            jsonResponse = "";
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject event = (JSONObject) response.get(i);

                                JSONObject calEvent = event.getJSONObject("calEvent");
                                String orgType = calEvent.getString("orgType");
                                String startDate = calEvent.getString("startDate");
                                String orgAddress = calEvent.getString("orgAddress");

                                //JSONObject phone = event.getJSONObject("phone");
                                //String home = phone.getString("home");
                                //String mobile = phone.getString("mobile");

                                jsonResponse += "OrgType: " + orgType + "\n\n";
                                jsonResponse += "Start: " + startDate + "\n\n";
                                jsonResponse += "Address: " + orgAddress + "\n\n";

                            }

                            mjsonText.setText(jsonResponse);

                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }

                        hidepDialog();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();
                hidepDialog();
            }
        });

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(req);
    }

    private void showpDialog() {
        if (!pDialog.isShowing())
            pDialog.show();
    }

    private void hidepDialog() {
        if (pDialog.isShowing())
            pDialog.dismiss();
    }
}
