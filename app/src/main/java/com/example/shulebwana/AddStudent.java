package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shulebwana.modal.Student;
import com.facebook.stetho.Stetho;

import java.util.List;

public class AddStudent extends AppCompatActivity {
    public String geder;


    EditText editfname, editSname, editMname, editEmail, editphonenumber, Birthdate;
    RadioGroup gender;
    Button butstudent;
    Spinner region,district,ward,pro;
    DatabaseHelper my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Stetho.initializeWithDefaults(this);
       my =new DatabaseHelper(this);
        editfname = (EditText) findViewById(R.id.editText3);
        editMname =  (EditText) findViewById(R.id.editText7);
        editSname = (EditText) findViewById(R.id.editText14);
        editEmail = (EditText) findViewById(R.id.editText8);
        editphonenumber = (EditText) findViewById(R.id.editText9);
        Birthdate =(EditText) findViewById(R.id.editText15);
        butstudent = (Button) findViewById(R.id.button11);
         region= findViewById(R.id.spinner3);
         district=findViewById(R.id.spinner4);
         ward=findViewById(R.id.spinner13);
         pro=findViewById(R.id.spinner14);

        List<String> programmes= my.getProgramme();
        ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,programmes );
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pro.setAdapter(data);




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

                      student.setStudentid(my.Studentidid());
                       student.setFirstname(editfname.getText().toString());
                       student.setSecondname(editMname.getText().toString());
                       student.setSurname(editSname.getText().toString());
                       student.setEmail(editEmail.getText().toString());
                       student.setBirthdate(Birthdate.getText().toString());
                       student.setPhonenumber(editphonenumber.getText().toString());
                       student.setGender(geder);
                       student.setRegion(region.getSelectedItem().toString());
                       student.setDistrict(district.getSelectedItem().toString());
                       student.setWard(ward.getSelectedItem().toString());
                       student.setPassword(student.getSurname().toUpperCase());
                       student.setPro(pro.getSelectedItem().toString());



  boolean isInserted = my.insertdatata(student);

                        if (isInserted =true)
                            Toast.makeText(AddStudent.this, "Data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(AddStudent.this, " Data not inserted", Toast.LENGTH_LONG).show();
                    }
                }

        );


    }}


























