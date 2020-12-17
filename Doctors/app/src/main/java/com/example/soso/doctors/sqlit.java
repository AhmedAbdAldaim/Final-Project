package com.example.soso.doctors;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by SoSo on 3/20/2020.
 */

public class sqlit extends SQLiteOpenHelper {
    private static final String DBname = "sav.db";

    public sqlit(Context context) {
            super(context, DBname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE tab(id INTEGER PRIMARY KEY AUTOINCREMENT,iduser TEXT,idpic TEXT,fname TEXT,lname TEXT,email TEXT,password TEXT,savedata TEXT)");
        ContentValues contentValues = new ContentValues();
        contentValues.put("iduser","null");
        contentValues.put("idpic","null");
        contentValues.put("fname","null");
        contentValues.put("lname","null");
        contentValues.put("email","null");
        contentValues.put("password","null");
        contentValues.put("savedata","0");
        db.insert("tab",null,contentValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tab");
        onCreate(db);
    }

    public String get_check()
    {
        String check;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor r = DB.rawQuery("select * from tab",null);
        r.moveToFirst();
        check =r.getString(r.getColumnIndex("savedata"));
        return check;
    }
    public String get_email()
    {
        String email;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor r = DB.rawQuery("select * from tab",null);
        r.moveToFirst();
        email =r.getString(r.getColumnIndex("email"));
        return email;
    }
    public String get_iduser()
    {
        String iduser;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor r = DB.rawQuery("select * from tab",null);
        r.moveToFirst();
        iduser =r.getString(r.getColumnIndex("iduser"));
        return iduser;
    }
    public String get_idpic()
    {
        String idpic;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor r = DB.rawQuery("select * from tab",null);
        r.moveToFirst();
        idpic =r.getString(r.getColumnIndex("idpic"));
        return idpic;
    }
    public String get_name()
    {
        String name;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor r = DB.rawQuery("select * from tab",null);
        r.moveToFirst();
        name =r.getString(r.getColumnIndex("name"));
        return name;
    }
    public String get_password()
    {
        String password;
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor r = DB.rawQuery("select * from tab",null);
        r.moveToFirst();
        password =r.getString(r.getColumnIndex("password"));
        return password;
    }
    public Boolean Update_r(String fname,String lname,String saved){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",fname);
        contentValues.put("lname",lname);
        contentValues.put("savedata",saved);
        DB.update("tab",contentValues,"id=?",new String[]{"1"});
        return true;
    }

    public Boolean Update_log(String iduser,String idpic,String emai,String password,String saved){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("iduser",iduser);
        contentValues.put("idpic",idpic);
        contentValues.put("email",emai);
        contentValues.put("password",password);
        contentValues.put("savedata",saved);
        DB.update("tab",contentValues,"id=?",new String[]{"1"});
        return true;
    }
}
