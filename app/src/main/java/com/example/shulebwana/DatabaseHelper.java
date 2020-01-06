package com.example.shulebwana;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static int version=1;
    private static String databasename="shulebwana";
    public static final String Firstname="FirstNAME";
    public  static final String SecondName="SecondNAME";
    public static final String Surname="SurNAME";
    public static final String Emaill="Email";
    public static final String phoneNumber="PHONENUMBER";
    public static final String birthdat="BIRTHDATE";



 private static String Administrator="CREATE TABLE ADMINISTRATOR(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "  + " FirstNAME TEXT  NOT NULL,"+"SecondNAME TEXT NOT NULL,"+ "SurNAME TEXT NOT NULL, " +"Email TEXT NOT NULL," + "PHONENUMBER INTERGER NOT NULL," +
         "BIRTHDATE TEXT NOT NULL," +
         "GENDER INTERGER " +
         ");";

    private static String student="CREATE TABLE STUDENT("+ "_id INTEGER PRIMARY KEY AUTOINCREMENT, " + " FirstNAME TEXT NOT NULL ,"  +"SecondNAME TEXT NOT NULL,"+ "SurNAME TEXT NOT NULL, " +"Email TEXT NOT NULL," + "PHONENUMBER TEXT NOT NULL," +
            "BIRTHDATE TEXT NOT NULL," +
            "GENDER INTERGER NOT NULL" +
            ");";
    private static String course="CREATE TABLE COURSE(" + "COURSECODE INTEGER PRIMARY KEY AUTOINCREMENT, " + " COURSENAME TEXT NOT NULL ,"  +"CREDITS INTERGER NOT NULL,"
            + "STUDYYEAR INTEGER NOT NULL, "
            +"SEMISTER INTERGER NOT NULL" +
            ");";
    private static String Staff="CREATE TABLE STAFF(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "  + " FirstNAME TEXT NOT NULL ,"+"SecondNAME TEXT NOT NULL,"+ "SurNAME TEXT NOT NULL, " +"Email TEXT NOT NULL," + "PHONENUMBER TEXT NOT NULL," +
            "BIRTHDATE NOT NULL," +
            "GENDER INTERGER " +
            ");";

    public DatabaseHelper(Context context) {
        super(context, databasename, null, version);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL(Administrator);
        sqLiteDatabase.execSQL(student);
        sqLiteDatabase.execSQL(course);
        sqLiteDatabase.execSQL(Staff);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {

   /*     onCreate(sqLiteDatabase);
*/
    }

    public boolean insertdata(String Fname,String Middle,String Surame,String Email,String birthdate,String phonenumber,String gender)
    {
        /*SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(Firstname,Fname);
        contentValues.put(SecondName,Middle);
        contentValues.put(Surname,Surame);
        contentValues.put(Emaill,Email);
        contentValues.put(phoneNumber,phonenumber);
        contentValues.put(birthdat,birthdate);
          long result= sq.insert(Administrator,null,contentValues);
*/
          if(true)
              return false;

          else
                 return true;



    }











}
