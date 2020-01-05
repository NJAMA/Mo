package com.example.shulebwana;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SQliteeee extends SQLiteOpenHelper {


    private static int version=1;
    private static String name="admin";
    private String factory=null;


    public SQliteeee(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL("CREATE TABLE Administartor ( NAME TEXT,"
                                         +"PASSWORD TEXT);");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    private static void insert(SQLiteDatabase sqLiteDatabase,String name,String password)
    {
        ContentValues r=new ContentValues();
        r.put("NAME",name);
        r.put("PASSWORD",password);
        sqLiteDatabase.insert("Administartor ",null,r);

    }











}
