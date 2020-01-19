package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.shulebwana.modal.Staff;
import com.example.shulebwana.modal.Student;
import com.facebook.stetho.Stetho;

public class addStaff extends AppCompatActivity {
    public String geder;


    EditText editfname, editSname, editMname, editEmail, editphonenumber, Birthdate;
    RadioGroup gender;
    Button butstudent;
    DatabaseHelper my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_staff);
        Stetho.initializeWithDefaults(this);

        editfname = (EditText) findViewById(R.id.editText3);
        editMname =  (EditText) findViewById(R.id.editText7);
        editSname = (EditText) findViewById(R.id.editText14);
        editEmail = (EditText) findViewById(R.id.editText8);
        editphonenumber = (EditText) findViewById(R.id.editText9);
        Birthdate =(EditText) findViewById(R.id.editText15);
        butstudent = (Button) findViewById(R.id.button11);

        regstrstaff();



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


    public void regstrstaff() {

        my = new DatabaseHelper(this);
        butstudent.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {

                        Staff staff=new Staff();
                        staff.setStaffid("565456111");
                        staff.setFirstname(editfname.getText().toString());
                        staff.setSecondname(editMname.getText().toString());
                        staff.setSurname(editSname.getText().toString());
                        staff.setEmail(editEmail.getText().toString());
                        staff.setBirthdate(Birthdate.getText().toString());
                        staff.setPhonenumber(editphonenumber.getText().toString());
                        staff.setGender(geder);
                        staff.setRegion("MBEYA");

                        staff.setDistrict("MBEYA");
                        staff.setPassword(staff.getSurname().toUpperCase());



                        boolean isInserted = my.insertdatatt(staff);

                        if (isInserted =true)
                            Toast.makeText(addStaff.this, "Data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(addStaff.this, " Data not inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );


    }}


























