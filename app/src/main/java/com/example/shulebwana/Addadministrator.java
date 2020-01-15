package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.facebook.stetho.*;

import com.example.shulebwana.modal.Administrator;
import java.time.*;


public class Addadministrator extends AppCompatActivity  {


/*
    LocalDate currentdate = LocalDate.now();

    int aa=currentdate.getYear();
*/
String ab="2020";


    public String geder;

    DatabaseHelper my;
    EditText editfname, editSname, editMname, editEmail, editphonenumber, Birthdate;
    RadioGroup gender;
    Button butAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadministrator);
      Stetho.initializeWithDefaults(this);
       my = new DatabaseHelper(this);


        editfname = (EditText) findViewById(R.id.editText3);
        editMname =  (EditText) findViewById(R.id.editText7);
        editSname = (EditText) findViewById(R.id.editText14);
        editEmail = (EditText) findViewById(R.id.editText8);
        editphonenumber = (EditText) findViewById(R.id.editText9);
        Birthdate =(EditText) findViewById(R.id.editText15);
        butAdmin = (Button) findViewById(R.id.button111);
        regstrAdmin();


    }

    public void onClicka(View view) {
        RadioGroup radioGroup =  findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioButton:
                geder = "M";
                break;
            case R.id.radioButton2:
                geder = "F";
        }
    }

   public void regstrAdmin() {


       butAdmin.setOnClickListener(

               new View.OnClickListener() {

                   @Override
                   public void onClick(View view) {
                     Administrator admin= new Administrator();
                     admin.setAdmin_no("AAAAA");
                       admin.setFirstname(editfname.getText().toString());
                       admin.setSecondname(editMname.getText().toString());
                       admin.setSurname(editSname.getText().toString());
                       admin.setEmail(editEmail.getText().toString());
                       admin.setBirthdate(Birthdate.getText().toString());
                       admin.setPhonenumber(editphonenumber.getText().toString());
                       admin.setGender(geder);
                       admin.setRegion("MBEYA");
                       admin.setDistrict("MBEYA");
                       admin.setPassword(admin.getSurname().toUpperCase());




                       boolean isInserted = my.insertdata(admin);

                    /*   boolean isInserted=my.insertdata(editfname.getText().toString(),editMname.getText().toString(),editSname.getText().toString(),editEmail.getText().toString(),editphonenumber.getText().toString(),"31101998",geder,"Mbeya",
                               "MBEYA","MBEYA",editSname.getText().toString().toUpperCase());*/
                       if (isInserted ==true)
                           Toast.makeText(Addadministrator.this, "Data inserted", Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(Addadministrator.this, " Data not inserted", Toast.LENGTH_LONG).show();
                   }
               }

       );


   }}




