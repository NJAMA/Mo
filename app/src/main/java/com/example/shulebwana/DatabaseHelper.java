package com.example.shulebwana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.shulebwana.modal.Administrator;
import com.example.shulebwana.modal.Course;
import com.example.shulebwana.modal.Login;
import com.example.shulebwana.modal.Staff;
import com.example.shulebwana.modal.Student;
import com.facebook.stetho.inspector.database.SqliteDatabaseDriver;

import java.util.ArrayList;
import java.util.List;


public class DatabaseHelper extends SQLiteOpenHelper {


    String ss;


    private static int version = 70;
    private static String databasename = "School";
    public static final String FIRSTNAME = "FIRSTNAME";
    public static final String TABLE = "ADMINSTRATOR";
    public static final String TABLE1 = "PROGRAMME";
    public static final String TABLE2 = "STUDENT";
    public static final String TABLE3 = "COURSE";
    public static final String TABLE4 = "STAFF";
    public static final String TABLE5 = "LOGIN";
    public static final String SECONDNAME = "SECONDNAME";
    public static final String SURNAME = "SURNAME";
    public static final String EMAIL = "EMAIL";
    public static final String PHONENUMBER = "PHONENUMBER";
    public static final String BIRTHDATE = "BIRTHDATE";
    public static final String GENDER = "GENDER";
    public static final String REGION = "REGION";
    public static final String WARD = "WARD";
    public static final String DISTRICT = "DISTRICT";
    public static final String PASSWORD = "PASSWORD";
    public static final String _id = "_id";

    private static String ADMINSTRATOR = "CREATE TABLE ADMINSTRATOR(" + _id + " TEXT PRIMARY KEY," + FIRSTNAME + " TEXT," + SECONDNAME + " TEXT ," + SURNAME + " TEXT," + EMAIL + " TEXT," + PHONENUMBER + " INTERGER," +
            BIRTHDATE + " TEXT," + GENDER + " TEXT," + REGION + " TEXT," + WARD + " TEXT," + DISTRICT + " TEXT, " + PASSWORD + " TEXT" + ");";


    private static String PROGRAMME = "CREATE TABLE PROGRAMME(" + _id +" INTEGER PRIMARY KEY AUTOINCREMENT," + "NAME TEXT" + ");";

    private static String COURSE = "CREATE TABLE COURSE(" + _id + " TEXT PRIMARY KEY," + "COURSENAME TEXT," + "CREDITS TEXT," + "YEAROFSTUDY TEXT," + "SEMISTER TEXT," + "CHOICE TEXT," + "programmeid TEXT," +
            "FOREIGN KEY(programmeid) REFERENCES PROGRAMME(" + _id + ")" + ");";

    private static String STUDENT = "CREATE TABLE STUDENT(" + _id + " TEXT PRIMARY KEY," + FIRSTNAME + " TEXT," + SECONDNAME + " TEXT ," + SURNAME + " TEXT, " + EMAIL + " TEXT," + PHONENUMBER + " INTERGER ," +
            BIRTHDATE + " TEXT," + GENDER + " TEXT,  " + REGION + " TEXT," + WARD + " TEXT," + DISTRICT + " TEXT , " + PASSWORD + " TEXT," + "programmeid TEXT," + "FOREIGN KEY(programmeid) REFERENCES PROGRAMME(" + _id + ")"
            + ");";


    private static String STAFF = "CREATE TABLE STAFF(" + _id + " TEXT PRIMARY KEY," + FIRSTNAME + " TEXT," + SECONDNAME + " TEXT ," + SURNAME + " TEXT , " + EMAIL + " TEXT," + PHONENUMBER + " INTERGER ," +
            BIRTHDATE + " TEXT," + GENDER + " TEXT,  " + REGION + " TEXT," + WARD + " TEXT," + DISTRICT + " TEXT, " + PASSWORD + " TEXT," + "programmeid TEXT," + "FOREIGN KEY(programmeid) REFERENCES PROGRAMME(" + _id + ")" + ");";

    private static String LOGIN = "CREATE TABLE LOGIN(" + "USERNAME TEXT PRIMARY KEY," + "PASSWORD TEXT,"+"ROLE TEXT" + ");";


    public DatabaseHelper(Context context) {
        super(context, databasename, null, version);
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        Data aa = new Data();
        Programme p = new Programme();
        sqLiteDatabase.execSQL(ADMINSTRATOR);
        sqLiteDatabase.execSQL(PROGRAMME);
        sqLiteDatabase.execSQL(COURSE);
        sqLiteDatabase.execSQL(STUDENT);
        sqLiteDatabase.execSQL(p.insertprogramme);
        sqLiteDatabase.execSQL(LOGIN);
        sqLiteDatabase.execSQL(STAFF);
        sqLiteDatabase.execSQL(aa.createDistrictTable);
        sqLiteDatabase.execSQL(aa.createRegionTable);
        sqLiteDatabase.execSQL(aa.createWardTable);
        sqLiteDatabase.execSQL(aa.insertDistricts);
        sqLiteDatabase.execSQL(aa.insertWardsGroup1);
        sqLiteDatabase.execSQL(aa.insertRegions);
        sqLiteDatabase.execSQL(aa.insertWardsGroup2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldversion, int newversion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE1);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE2);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE3);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE4);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE5);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "districts");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "regions");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "wards");
        onCreate(sqLiteDatabase);

    }

    public boolean insertdata(Administrator adminn) {
        SQLiteDatabase sq = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        ContentValues user = new ContentValues();

        contentValues.put(_id, adminn.getAdmin_no());
        contentValues.put(FIRSTNAME, adminn.getFirstname());
        contentValues.put(SECONDNAME, adminn.getSecondname());
        contentValues.put(SURNAME, adminn.getSurname());
        contentValues.put(EMAIL, adminn.getEmail());
        contentValues.put(PHONENUMBER, adminn.getPhonenumber());
        contentValues.put(BIRTHDATE, adminn.getBirthdate());
        contentValues.put(GENDER, adminn.getGender());
        contentValues.put(REGION, adminn.getRegion());
        contentValues.put(WARD, adminn.getWard());
        contentValues.put(DISTRICT, adminn.getDistrict());
        contentValues.put(PASSWORD, adminn.getPassword());















        user.put("USERNAME", adminn.getAdmin_no());
        user.put(PASSWORD, adminn.getPassword());
        user.put("ROLE",1);


        long result = sq.insert(TABLE, null, contentValues);

        long resul = sq.insert(TABLE5, null, user);

        if (result == -1)
            return false;
        else
            return true;

    }
 String a;
    public boolean insertdatata(Student student) {
        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        ContentValues user = new ContentValues();
        contentValues.put(_id, student.getStudent());
        contentValues.put(FIRSTNAME, student.getFirstname());
        contentValues.put(SECONDNAME, student.getSecondname());
        contentValues.put(SURNAME, student.getSurname());
        contentValues.put(EMAIL, student.getEmail());
        contentValues.put(PHONENUMBER, student.getPhonenumber());
        contentValues.put(BIRTHDATE, student.getBirthdate());
        contentValues.put(GENDER, student.getGender());
        contentValues.put(REGION, student.getRegion());
        contentValues.put(WARD, student.getWard());
        contentValues.put(DISTRICT, student.getDistrict());
        contentValues.put(PASSWORD, student.getPassword());

        user.put("USERNAME", student.getStudent());
        user.put(PASSWORD, student.getPassword());
        user.put("ROLE",2);

        switch(student.getPro())
        {
            case "BSC IN COMPUTER SCIENCE":
                a="1";
                break;

            case "BSC IN COMPUTER ENGINEERING":
                a="2";
            case "BSC IN TELCOM":
                a="3";
            case"BSC IN ELECTRONIC":
                a="4";

        }

        contentValues.put("programmeid",a);


        long result = sq.insert(TABLE2, null, contentValues);
        long resul = sq.insert(TABLE5, null, user);
        sq.close();
        if (result == -1)
            return false;
        else
            return true;

    }


    public boolean insertCourse(Course c) {

        SQLiteDatabase sq = this.getWritableDatabase();
        ContentValues cc = new ContentValues();

        cc.put("COURSENAME", c.getCoursename());
        cc.put("CREDITS", c.getCredits());
        cc.put("YEAROFSTUDY", c.getYearofstudy());
        cc.put("SEMISTER", c.getSemister());
        cc.put(_id, c.getCoursecode());



        switch(c.getPro())
        {
            case "BSC IN COMPUTER SCIENCE":
                a="1";
                break;

            case "BSC IN COMPUTER ENGINEERING":
                a="2";
            case "BSC IN TELCOM":
                a="3";
            case"BSC IN ELECTRONIC":
                a="4";

        }
/*
        cc.put("programmeid",a);*/

        long result = sq.insert(TABLE3, null, cc);
        /* long resul= sq.insert(TABLE5,null,user);*/
        sq.close();
        if (result == -1)
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
        user.put("ROLE",3);


        switch(staff.getPro())
        {
            case "BSC IN COMPUTER SCIENCE":
                a="1";
                break;

            case "BSC IN COMPUTER ENGINEERING":
                a="2";
            case "BSC IN TELCOM":
                a="3";
            case"BSC IN ELECTRONIC":
                a="4";

        }

        contentValues.put("programmeid",a);









        long result= sq.insert(TABLE4,null,contentValues);
        long resul= sq.insert(TABLE5,null,user);

        if(result == -1)
            return false;
        else
            return true;

    }


  public  ArrayList<String> getR()
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor reg =sq.rawQuery("select region_name FROM regions ",null);
        ArrayList<String> aa= new ArrayList<>();
        while(reg.moveToNext() )
        {
            String name = reg.getString(0);

        aa.add(name);
        }

        return aa;
    }

    public  List<String> getD(String region) {

        SQLiteDatabase sq = this.getWritableDatabase();
        String[] sele = new String[]{region};
        Cursor rag = sq.rawQuery("select region_code FROM regions WHERE region_name=?", sele);

        while (rag.moveToNext()) {

            ss = rag.getString(0);

    }

        String[] selectionArgs= new String[]{ss};
        Cursor reg =sq.rawQuery("select district_name FROM districts WHERE region_code=?",selectionArgs);

        ArrayList<String> bb= new ArrayList<>();


        while(reg.moveToNext() )
        {
            String name = reg.getString(0);

            bb.add(name);
        }

        return bb;
    }






    public List<String> getProgramme()
    {

        SQLiteDatabase sq=this.getReadableDatabase();
        Cursor aa=sq.rawQuery("select NAME FROM PROGRAMME ",null);
        ArrayList<String>qa=new ArrayList<>();

        while(aa.moveToNext())
        {
            String aq=aa.getString(0);
            qa.add(aq);
        }


return qa;

    }




    String naem;

    public  List<String> getW(String distric)
    {


        List<String>cc=new ArrayList<>();
        SQLiteDatabase sq=this.getWritableDatabase();
      String[] selec=new String[]{distric};
        Cursor qa=sq.rawQuery("select district_code FROM districts WHERE district_name=?",selec);

       while(qa.moveToNext()) {
           naem = qa.getString(0);
       }

       String[] nnn=new String[]{naem};

        Cursor rega=sq.rawQuery("select ward_name FROM wards WHERE district_code=? ",nnn);

        while(rega.moveToNext() )
        {
            String name = rega.getString(0);

            cc.add(name);
        }

        return cc;
    }

   String z;
    String napp;
    int bb;

public String Studentidid()
{
    SQLiteDatabase sq=this.getWritableDatabase();

    Cursor rag=sq.rawQuery("select _id FROM STUDENT",null);
    if(rag.getCount()==0)
     {
        return"2020-04-0000";
     }

    boolean toLast = rag.moveToLast();

    napp = rag.getString(0);

             bb=Integer.parseInt(napp.substring(8,12));
        ++bb;
        z="2020-04-000"+ bb;



    return z;

}

  String zz;
String aa;
  public String staffid()
  {

      SQLiteDatabase sq=this.getWritableDatabase();
      Cursor lap=sq.rawQuery("select _id FROM STAFF",null);
      if(lap.getCount()==0)
      {
          return "0001A";

      }
      boolean tof=lap.moveToLast();

      zz=lap.getString(0);

     String ss= zz.substring(4);
               char aa=ss.charAt(0);
                ++aa;

                String dd="0001"+aa;
               return dd;


  }


public Login login(Login lo)
{
    SQLiteDatabase sq=this.getReadableDatabase();
 String pp=lo.getPassword();
 String usr=lo.getUsername();
ArrayList<Login> liii= new ArrayList<Login>();
    String[] pass=new String[]{pp};
    String[] userr=new String[]{usr,pp};

    Cursor lapp=sq.rawQuery("select * FROM LOGIN WHERE username=? AND password=?",userr);

lapp.moveToNext();

Login aa= new Login();

    aa.setPassword(lapp.getString(1));
     aa.setUsername(lapp.getString(0));
     aa.setRole(lapp.getString(2));

return aa;

}



public  void getStudent(){

    SQLiteDatabase sq =this.getReadableDatabase();
    Cursor lapa=sq.rawQuery("select * FROM STUDENT ",null);
    lapa.moveToFirst();
String a=lapa.getString(6);


ArrayList<String> aa= new ArrayList<>();
aa.add(a);







}


public void getSraff()
{



}

public void Admin()
{}




















}

