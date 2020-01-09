package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.shulebwana.modal.Administrator;

public class Addadministrator extends AppCompatActivity  {

    Administrator admin;
    public String geder;

    DatabaseHelper my;
    EditText editfname, editSname, editMname, editEmail, editphonenumber, Birthdate;
    RadioGroup gender;
    Button butAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addadministrator);

       my = new DatabaseHelper(this);

        editfname = findViewById(R.id.editText3);
        editMname =  findViewById(R.id.editText7);
        editSname = findViewById(R.id.editText14);
        editEmail = findViewById(R.id.editText8);
        editphonenumber =  findViewById(R.id.editText15);
        Birthdate = findViewById(R.id.editText5);
        butAdmin =  findViewById(R.id.button11);

        regstrAdmin();/*  butAdmin.setOnClickListener(this);*/


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

                       admin.setFirstname(editfname.getText().toString());
                       admin.setSecondname(editMname.getText().toString());
                       admin.setSurname(editSname.getText().toString());
                       admin.setEmail(editEmail.getText().toString());
                       admin.setBirthdate(Birthdate.getText().toString());
                       admin.setPhonenumber(editphonenumber.getText().toString());
                       admin.setGender(geder);
                       admin.setRegion("");
                       admin.setDistrict("");
                       admin.setAdmin_no("");
                       admin.setPassword(admin.getSurname().toUpperCase());


                       boolean isInserted = my.insertdata(admin);


                       if (isInserted == true)
                           Toast.makeText(Addadministrator.this, "Data inserted", Toast.LENGTH_LONG).show();
                       else
                           Toast.makeText(Addadministrator.this, " Data notinserted", Toast.LENGTH_LONG).show();
                   }
               }

       );


   }}



