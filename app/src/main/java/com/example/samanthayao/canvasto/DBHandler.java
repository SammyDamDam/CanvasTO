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


    //create a new table that stores information
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE_TABLE " + TABLE_PRODUCTS + "(" +
                COLUMN_ID + " Username " +
                COLUMN_PRODUCTNAME + " Password " +
                ");";
        db.execSQL(query);
    }

    //upgrade db version or make new table
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_PRODUCTS);
        onCreate(db);
    }

    //add new row to db
    public void addProduct(Product product) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, product.get_username());
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS, null, values);
        db.close();
    }

    //delete from db
    public void deleteProduct(String productName) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\"" + productName + "\";");

    }

}
