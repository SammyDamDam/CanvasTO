package com.example.samanthayao.canvasto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    public static final String JSON_ARRAY = "";
    public static final String JSON_OBJECT = "calEvent";
    public static final String KEY_ORGTYPE= "orgType";
    public static final String KEY_STARTDATE = "startDate";
    public static final String KEY_ORGADDRESS = "orgAddress";
    public static final String KEY_ENDDATE= "endDate";
    public static final String KEY_EVENTWEBSITE = "eventWebsite";
    public static final String KEY_DESCRIPTION = "description";
    public static final String KEY_EVENTNAME = "eventName";

    private JSONObject info = null;

    private String json;

    public JSONParser(String json){
        this.json = json;
    }

    protected void parseJSON() {
        JSONArray jsonArray = null;
        try{
            jsonArray = new JSONArray(json);
            info = jsonArray.getJSONObject(0);

            orgType = new String[info.length()];
            startDate = new String[info.length()];
            orgAddress = new String[info.length()];
            endDate = new String[info.length()];
            eventWebsite = new String[info.length()];
            description = new String[info.length()];
            eventName = new String[info.length()];

            for(int i=0;i<info.length();i++){
                JSONObject jo = info.getJSONObject(JSON_OBJECT);
                orgType[i] = jo.getString(KEY_ORGTYPE);

            }
        }
        catch(JSONException e){
            e.printStackTrace();
        }

    }
}