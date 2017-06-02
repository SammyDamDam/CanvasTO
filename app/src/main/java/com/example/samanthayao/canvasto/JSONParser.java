package com.example.samanthayao.canvasto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONParser extends AppCompatActivity {
    public static String[] orgType;
    public static String[] startDate;
    public static String[] orgAddress;
    public static String[] endDate;
    public static String[] eventWebsite;
    public static String[] description;
    public static String[] freeEvent;
    public static String[] eventName;

    public static final String JSON_OBJECT = "calEvent";
    public static final String KEY_ORGTYPE= "orgType";
    public static final String KEY_STARTDATE = "startDate";
    public static final String KEY_ORGADDRESS = "orgAddress";
    public static final String KEY_ENDDATE= "endDate";
    public static final String KEY_EVENTWEBSITE = "eventWebsite";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_FREEEVENT = "freeEvent";
    public static final String KEY_EVENTNAME = "eventName";

    private JSONObject users = null;

    private String json;

    public JSONParser(String json){
        this.json = json;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsonparser);

        JSONArray jsonArray = null;
        try{
            jsonArray = new JSONArray(json);
            users = jsonArray.getJSONObject(Integer.parseInt(JSON_OBJECT));
        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }
}