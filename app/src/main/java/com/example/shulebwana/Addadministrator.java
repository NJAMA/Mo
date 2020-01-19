package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import com.facebook.stetho.*;

import com.example.shulebwana.modal.Administrator;
import java.time.*;
import java.util.List;


public class Addadministrator extends AppCompatActivity  {


/*
    LocalDate currentdate = LocalDate.now();

    int aa=currentdate.getYear();
*/
String ab="2020";

   /* final DatabaseHelper database = new DatabaseHelper(getContext());*/

    public String geder;
   /* DatabaseHelper myc= new DatabaseHelper(get);*/

    DatabaseHelper my;
    EditText editfname, editSname, editMname, editEmail, editphonenumber, Birthdate;
    RadioGroup gender;
    Spinner region,district,ward,spinner5;
    Button butAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadministrator);
        Stetho.initializeWithDefaults(this);
        my = new DatabaseHelper(this);


        editfname = (EditText) findViewById(R.id.editText3);
        editMname = (EditText) findViewById(R.id.editText7);
        editSname = (EditText) findViewById(R.id.editText14);
        editEmail = (EditText) findViewById(R.id.editText8);
        editphonenumber = (EditText) findViewById(R.id.editText9);
        Birthdate = (EditText) findViewById(R.id.editText15);
        butAdmin = (Button) findViewById(R.id.button111);
        region = findViewById(R.id.spinner2);
        district = findViewById(R.id.spinner3);
        spinner5 = findViewById(R.id.spinner5);
        ward = findViewById(R.id.spinner4);


        List<String> regionsList = my.getR();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regionsList);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        region.setAdapter(dataAdapter);


        region.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Populate districts
                List<String> districtsList = my.getD(region.getItemAtPosition(position).toString());
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, districtsList);
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                district.setAdapter(dataAdapter);

                // Listen to district selection
                district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                        // Populate districts
                        List<String> wardList = my.getW(district.getItemAtPosition(position).toString());
                        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, wardList);
                        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        ward.setAdapter(dataAdapter);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parentView) {
                        // your code here
                    }

                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

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


