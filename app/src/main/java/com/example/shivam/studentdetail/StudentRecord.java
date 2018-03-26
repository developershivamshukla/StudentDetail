package com.example.shivam.studentdetail;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

/**
 * Created by Shivam on 08-02-2018.
 */

public class StudentRecord extends SQLiteOpenHelper {
    public StudentRecord(Context context) {
        super(context, "Aryaa",null,2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tab = "CREATE TABLE record(roll VARCHAR, name VARCHAR, mobile VARCHAR,city VARCHAR)";
        db.execSQL(tab);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void studentdata(String rl,String nm,String mob,String ct ){
        SQLiteDatabase d =this.getWritableDatabase();
        ContentValues c =new ContentValues();
        c.put("roll",rl);
        c.put("name",nm);
        c.put("mobile",mob);
        c.put("city",ct);
        d.insert("record",null,c);
        d.close();

    }
    public Cursor getrecord()
    {
        SQLiteDatabase d =this.getWritableDatabase();
        String get ="SELECT * FROM record";
        Cursor c = d.rawQuery(get,null);
        return c;
    }
    public Cursor getOne(String r1)
    {
        Cursor c = null;
        SQLiteDatabase d = this.getWritableDatabase();
        String get ="SELECT * FROM record WHERE roll = '"+r1+"'";
        c = d.rawQuery(get,null);
        return c;
    }
}
