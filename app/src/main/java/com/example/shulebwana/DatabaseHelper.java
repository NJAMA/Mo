package com.example.shulebwana;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.health.PackageHealthStats;

import com.example.shulebwana.modal.Administrator;
import com.example.shulebwana.modal.Staff;
import com.example.shulebwana.modal.Student;


public class DatabaseHelper extends SQLiteOpenHelper {


    private static int version=6;
    private static String databasename="School";
    public static final String FIRSTNAME="FIRSTNAME";
    public static final String TABLE="ADMINSTRATOR";
    public static final String TABLE1="PROGRAMME";
    public static final String TABLE2="STUDENT";
    public static final String TABLE3="COURSE";
    public static final String TABLE4="STAFF";
    public static  final String TABLE5="LOGIN";
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
    public static final String _id="_id";

    private static String ADMINSTRATOR="CREATE TABLE ADMINSTRATOR(" + _id +" TEXT PRIMARY KEY," +FIRSTNAME+" TEXT,"+SECONDNAME+ " TEXT ,"+ SURNAME+" TEXT," +EMAIL+" TEXT," + PHONENUMBER +" INTERGER," +
         BIRTHDATE +" TEXT," +GENDER+ " TEXT," +REGION+ " TEXT,"+WARD + " TEXT,"+ DISTRICT+ " TEXT, "+PASSWORD +" TEXT"+");";

    /*private static String ADMINADDRESS="CREATE TABLE ADMINADRESS(" + "_id INTEGER PRIMARY KEY, "  +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ," +
            ");";*/

    private static String PROGRAMME="CREATE TABLE PROGRAMME("+_id+" TEXT PRIMARY KEY,"+ "NAME TEXT"+");";

    private static String COURSE="CREATE TABLE COURSE("+_id+" TEXT PRIMARY KEY,"+ "COURSENAME TEXT,"+"CREDITS TEXT,"+"YEAROFSTUDY TEXT,"+"SEMISTER TEXT,"+"CHOICE TEXT" +");";

    private static String STUDENT="CREATE TABLE STUDENT(" + _id +" TEXT PRIMARY KEY,"  +FIRSTNAME+" TEXT,"+SECONDNAME+ " TEXT ,"+ SURNAME+" TEXT, " +EMAIL+" TEXT," + PHONENUMBER +" INTERGER ," +
            BIRTHDATE +" TEXT," +GENDER +" TEXT,  " +REGION+" TEXT,"+WARD +" TEXT,"+ DISTRICT+" TEXT , "+PASSWORD +" TEXT" +");";



   /* private static String STUDENTADDRESS="CREATE TABLE ADMINADRESS(" + "_id INTEGER PRIMARY KEY, "  +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ," +
            ");";*/
   private static String STAFF="CREATE TABLE STAFF(" + _id +" TEXT PRIMARY KEY,"  + FIRSTNAME+" TEXT,"+SECONDNAME+ " TEXT ,"+ SURNAME+" TEXT , " +EMAIL+" TEXT," + PHONENUMBER +" INTERGER ," +
           BIRTHDATE +" TEXT," + GENDER +" TEXT,  "   +  REGION+" TEXT,"+WARD +" TEXT,"+ DISTRICT+" TEXT, " +PASSWORD +" TEXT" +");";

private static String LOGIN="CREATE TABLE LOGIN("+"USERNAME TEXT,"+"PASSWORD TEXT"+");";

/*private static String STAFFADRESS="CREATE TABLE ADMINADRESS(" + "_id INTEGER PRIMARY KEY, "  +  REGION+" TEXT,"+WARD +"TEXT,"+ DISTRICT+" TEXT , " +WARD+" TEXT ," +
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
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " +TABLE1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE2);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE3);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE4);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE5);
        onCreate(sqLiteDatabase);

    }

    public boolean insertdata(Administrator adminn)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        ContentValues user= new ContentValues();
       contentValues.put(_id,adminn.getAdmin_no());
        contentValues.put(FIRSTNAME,adminn.getFirstname());
        contentValues.put(SECONDNAME,adminn.getSecondname());
        contentValues.put(SURNAME,adminn.getSurname());
        contentValues.put(EMAIL,adminn.getEmail());
        contentValues.put(PHONENUMBER,adminn.getPhonenumber());
        contentValues.put(BIRTHDATE,adminn.getBirthdate());
        contentValues.put(GENDER,adminn.getGender());
        contentValues.put(REGION,adminn.getRegion());
        contentValues.put(WARD,adminn.getWard());
        contentValues.put(DISTRICT,adminn.getDistrict());
        contentValues.put(PASSWORD,adminn.getPassword());
        user.put("USERNAME",adminn.getAdmin_no());
        user.put(PASSWORD,adminn.getPassword());


        long result= sq.insert(TABLE,null,contentValues);
        long resul= sq.insert(TABLE5,null,user);

          if(result == -1)
              return false;
          else
        return true;

    }

   public boolean insertdatata(Student student)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        ContentValues user= new ContentValues();
        contentValues.put(_id,student.getStudent());
        contentValues.put(FIRSTNAME,student.getFirstname());
        contentValues.put(SECONDNAME,student.getSecondname());
        contentValues.put(SURNAME,student.getSurname());
        contentValues.put(EMAIL,student.getEmail());
        contentValues.put(PHONENUMBER,student.getPhonenumber());
        contentValues.put(BIRTHDATE,student.getBirthdate());
        contentValues.put(GENDER,student.getGender());
        contentValues.put(REGION,student.getRegion());
        contentValues.put(WARD,student.getWard());
        contentValues.put(DISTRICT,student.getDistrict());
        contentValues.put(PASSWORD,student.getPassword());
        user.put("USERNAME",student.getStudent());
        user.put(PASSWORD,student.getPassword());

        long result= sq.insert(TABLE2,null,contentValues);
        long resul= sq.insert(TABLE5,null,user);

        if(result == -1)
            return false;
        else
            return true;

    }



    public boolean insertdatatt(Staff staff)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        ContentValues user= new ContentValues();
        contentValues.put(_id,staff.getStaffid());
        contentValues.put(FIRSTNAME,staff.getFirstname());
        contentValues.put(SECONDNAME,staff.getSecondname());
        contentValues.put(SURNAME,staff.getSurname());
        contentValues.put(EMAIL,staff.getEmail());
        contentValues.put(PHONENUMBER,staff.getPhonenumber());
        contentValues.put(BIRTHDATE,staff.getBirthdate());
        contentValues.put(GENDER,staff.getGender());
        contentValues.put(REGION,staff.getRegion());
        contentValues.put(WARD,staff.getWard());
        contentValues.put(DISTRICT,staff.getDistrict());
        contentValues.put(PASSWORD,staff.getPassword());
        user.put("USERNAME",staff.getStaffid());
        user.put(PASSWORD,staff.getPassword());

        long result= sq.insert(TABLE4,null,contentValues);
        long resul= sq.insert(TABLE5,null,user);

        if(result == -1)
            return false;
        else
            return true;

    }























}
