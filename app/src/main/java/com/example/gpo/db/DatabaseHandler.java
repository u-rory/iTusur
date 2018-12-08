package com.example.gpo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gpo.Data.Day;
import com.example.gpo.Data.NEWSS;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler extends SQLiteOpenHelper implements IDatabaseHandler {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "timetable.db";

    public static final String TABLE_NAME = "day";
    public static final String KEY_ID = "_id";
    public static final String KEY_PREDMET = "predmet";
    public static final String KEY_TYPE = "type";
    public static final String KEY_AUD = "aud";
    public static final String KEY_PREPOD = "prepod";

    public static final String TABLE_NEWS = "newspaper";
    public static final String KEY_ANNOTATION = "annotation";
    public static final String KEY_DATE = "data";
    public static final String KEY_LINK = "link";
    public static final String KEY_NAME = "name";
    public static final String KEY_IMAGES = "images";
    public static final String KEY_ID2 = "_id";

    public DatabaseHandler(Context context) {super(context, DATABASE_NAME, null, DATABASE_VERSION);}
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_PREDMET + " TEXT, " + KEY_TYPE + " TEXT, " + KEY_AUD + " TEXT, "+ KEY_PREPOD + " TEXT);");
        db.execSQL("CREATE TABLE " + TABLE_NEWS + " (" + KEY_ID2 +" INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_ANNOTATION + " TEXT, " +KEY_DATE + " TEXT, " + KEY_LINK +" TEXT, " + KEY_NAME + " TEXT, " + KEY_IMAGES + " TEXT);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       // db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);onCreate(db);
    }
    @Override
    public void addDay(Day day) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PREDMET, day.getPredmet());
        values.put(KEY_TYPE, day.getType());
        values.put(KEY_AUD, day.getAud());
        values.put(KEY_PREPOD, day.getPrepod());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    @Override
    public void addNews(NEWSS newss) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ANNOTATION, newss.getText());
        values.put(KEY_DATE, newss.getDate());
        values.put(KEY_LINK, newss.getLink());
        values.put(KEY_NAME, newss.getName());
        values.put(KEY_IMAGES, newss.getImages());
        db.insert(TABLE_NEWS, null, values);
        db.close();
    }
    @Override
    public List<Day> getAllDay() {
        List<Day> dayList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Day day = new Day();
                day.setID(Integer.parseInt(cursor.getString(0)));
                day.setPredmet(cursor.getString(1));
                day.setType(cursor.getString(2));
                day.setAud(cursor.getString(3));
                day.setPrepod(cursor.getString(4));
                dayList.add(day);
            } while (cursor.moveToNext());
        }

        return dayList;
    }
    @Override
    public List<NEWSS> getAllNews() {
        List<NEWSS> NewsList = new ArrayList<>();
        String selectQuery = "SELECT  * FROM " + TABLE_NEWS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                NEWSS news = new NEWSS();
                news.setID(Integer.parseInt(cursor.getString(0)));
                news.setText(cursor.getString(1));
                news.setDate(cursor.getString(2));
                news.setLink(cursor.getString(3));
                news.setName(cursor.getString(4));
                news.setImages(cursor.getString(5));
                NewsList.add(news);
            } while (cursor.moveToNext());
        }

        return NewsList;
    }
    @Override
    public void deleteAllDay() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }
    @Override
    public void deleteAllNews() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NEWS, null, null);
        db.close();
    }

    @Override
    public int getDaysCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();
    }
    @Override
    public int getNewsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NEWS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        return cursor.getCount();
    }
}



