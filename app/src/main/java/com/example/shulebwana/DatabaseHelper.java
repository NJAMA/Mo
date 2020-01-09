package com.example.shulebwana;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.shulebwana.modal.Administrator;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static int version=1;
    private static String databasename="shulebwana";
    public static final String FIRSTNAME="FIRSTNAME";
    public  static final String SECONDNAME="SECONDNAME";
    public static final String SURNAME="SURNAME";
    public static final String EMAIL="EMAIL";
    public static final String PHONENUMBER="PHONENUMBER";
    public static final String BIRTHDATE="BIRTHDATE";
    public static final String GENDER="GENDER";
    public static final String REGION="REGION";
    public static final String WARD="WARD";
    public static final String DISTRICT="DISTRICT";
    public static final String PASSWORD="PASSWORD";

    private static String ADMINSTRATOR="CREATE TABLE ADMINISTRATOR(" + "_id TEXT PRIMARY KEY , "  + FIRSTNAME+" TEXT,"+SECONDNAME+ "TEXT ,"+ SURNAME+"TEXT , " +EMAIL+" TEXT," + PHONENUMBER +"INTERGER ," +
         BIRTHDATE +"TEXT ," + GENDER +"TEXT,  "   +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , "+"PASSWORD TEXT"+");";

    /*private static String ADMINADDRESS="CREATE TABLE ADMINADRESS(" + "_id INTEGER PRIMARY KEY, "  +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ," +
            ");";*/

    private static String PROGRAMME="CREATE TABLE PROGRAMME("+"_id TEXT PRIMARY KEY,"+ "NAME TEXT"+");";

    private static String COURSE="CREATE TABLE COURSE("+"_id TEXT PRIMARY KEY,"+ "COURSENAME TEXT,"+"CREDITS TEXT,"+"YEAROFSTUDY TEXT,"+"SEMISTER TEXT,"+"CHOICE TEXT" +");";

    private static String STUDENT="CREATE TABLE STUDENT(" + "_id TEXT PRIMARY KEY , "  + FIRSTNAME+" TEXT,"+SECONDNAME+ "TEXT ,"+ SURNAME+"TEXT , " +EMAIL+" TEXT," + PHONENUMBER +"INTERGER ," + BIRTHDATE +"TEXT ," + GENDER +"TEXT,  "   +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ,"+"PASSWORD TEXT" +");";



   /* private static String STUDENTADDRESS="CREATE TABLE ADMINADRESS(" + "_id INTEGER PRIMARY KEY, "  +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ," +
            ");";*/
   private static String STAFF="CREATE TABLE STAFF(" + "_id TEXT PRIMARY KEY , "  + FIRSTNAME+" TEXT,"+SECONDNAME+ "TEXT ,"+ SURNAME+"TEXT , " +EMAIL+" TEXT," + PHONENUMBER +"INTERGER ," +
           BIRTHDATE +"TEXT ," + GENDER +"TEXT,  "   +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ,"+"PASSWORD TEXT" +");";

private static String LOGIN="CREATE TABLE LOGIN("+"USERNAME TEXT,"+"PASSWORD TEXT"+");";

/* private static String STAFFADRESS="CREATE TABLE ADMINADRESS(" + "_id INTEGER PRIMARY KEY, "  +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ," +
            ");";*/

    public DatabaseHelper(Context context) {
        super(context, databasename, null, version);
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

       sqLiteDatabase.execSQL(ADMINSTRATOR);
        sqLiteDatabase.execSQL(PROGRAMME);
        sqLiteDatabase.execSQL(COURSE);
        sqLiteDatabase.execSQL(STUDENT);
        sqLiteDatabase.execSQL(LOGIN);
        sqLiteDatabase.execSQL(STAFF);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {

   /*     onCreate(sqLiteDatabase);
*/
    }

    public boolean insertdata(Administrator admin)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        contentValues.put(FIRSTNAME,admin.getFirstname());
        contentValues.put(SECONDNAME,admin.getSecondname());
        contentValues.put(SURNAME,admin.getSurname());
        contentValues.put(EMAIL,admin.getEmail());
        contentValues.put(PHONENUMBER,admin.getPhonenumber());
        contentValues.put(BIRTHDATE,admin.getBirthdate());
        contentValues.put(GENDER,admin.getGender());
        contentValues.put(REGION,admin.getRegion());
        contentValues.put(WARD,admin.getWard());
        contentValues.put(DISTRICT,admin.getDistrict());
        contentValues.put(PASSWORD,admin.getPassword());

          long result= sq.insert(ADMINSTRATOR,null,contentValues);

          if(true)
              return false;

          else
                 return true;



    }











}
