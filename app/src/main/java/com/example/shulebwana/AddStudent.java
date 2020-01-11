package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.shulebwana.modal.Student;
import com.facebook.stetho.Stetho;

public class AddStudent extends AppCompatActivity {
    public String geder;


    EditText editfname, editSname, editMname, editEmail, editphonenumber, Birthdate;
    RadioGroup gender;
    Button butstudent;
    DatabaseHelper my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Stetho.initializeWithDefaults(this);



        editfname = (EditText) findViewById(R.id.editText3);
        editMname =  (EditText) findViewById(R.id.editText7);
        editSname = (EditText) findViewById(R.id.editText14);
        editEmail = (EditText) findViewById(R.id.editText8);
        editphonenumber = (EditText) findViewById(R.id.editText9);
        Birthdate =(EditText) findViewById(R.id.editText15);
        butstudent = (Button) findViewById(R.id.button11);
        regstrstudent();



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


    public void regstrstudent() {

       my = new DatabaseHelper(this);
        butstudent.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {


                        Student student= new Student();
                      student.setStudentid("565456");
                       student.setFirstname(editfname.getText().toString());
                       student.setSecondname(editMname.getText().toString());
                       student.setSurname(editSname.getText().toString());
                       student.setEmail(editEmail.getText().toString());
                       student.setBirthdate(Birthdate.getText().toString());
                       student.setPhonenumber(editphonenumber.getText().toString());
                       student.setGender(geder);
                       student.setRegion("MBEYA");

                       student.setDistrict("MBEYA");
                       student.setPassword(student.getSurname().toUpperCase());



  boolean isInserted = my.insertdatata(student);

                        if (isInserted =true)
                            Toast.makeText(AddStudent.this, "Data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddStudent.this, " Data not inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );


    }}


























