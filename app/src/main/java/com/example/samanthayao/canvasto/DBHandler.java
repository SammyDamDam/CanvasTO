package com.example.samanthayao.canvasto;

import android.database.sqlite.*;
import android.database.Cursor;
import android.content.*;


/**
 * Created by Arthur Lin on 2017-06-08.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "logins.db";
    public static final String TABLE_PRODUCTS = "login";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_PRODUCTNAME = "productname";
    //
    public DBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //create the table that stores information
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE_TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " Username " +
                COLUMN_PRODUCTNAME + " Password " +
                ");";
        db.execSQL(query);
    }

    //upgrade db version
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }
}
