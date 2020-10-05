package com.example.geofencing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyDataBase extends SQLiteOpenHelper {
    public SQLiteDatabase myDatabase;
    public MyDataBase(Context context) {
        super(context, "MyDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table GeoDetails" + "( id integer primary key autoincrement," + "geoId text," + "lat double," + "lon double," + "radius float"+ ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void insertGeoData(String geoId, double lat, double lon, float radius) {
        try {
            myDatabase = this.getWritableDatabase();
            ContentValues dataToInsert = new ContentValues();
            dataToInsert.put("geoId", geoId);
            dataToInsert.put("lat", lat);
            dataToInsert.put("lon", lon);
            dataToInsert.put("radius", radius);
            myDatabase.insertOrThrow("GeoDetails", null, dataToInsert);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<GeoData> getAllData() {
        List<GeoData> productItems = new ArrayList<>();
        Cursor cursor = null;
        SQLiteDatabase database = this.getReadableDatabase();
        cursor = database.rawQuery("SELECT * FROM GeoDetails", null);
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                GeoData productItem = new GeoData(cursor.getString(1), cursor.getDouble(2), cursor.getDouble(3), cursor.getFloat(4));
                productItems.add(productItem);
            }
        }
        cursor.close();
        return productItems;
    }
}
