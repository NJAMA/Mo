package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Administrator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrator);



    }



    public void course(View v)
    {
        Intent one= new Intent(this,addCourse.class);
        startActivity(one);
    }

    public void staff(View v)
    {
        Intent one=new Intent(this,addStaff.class);
        startActivity(one);

    }

    public void admin(View v)
    {

        Intent one= new Intent(this,Addadministrator.class);
        startActivity(one);

    }


    public void addstudent(View v)
    {

        Intent one= new Intent(this,AddStudent.class);
        startActivity(one);

    }




    public void viewcourse(View v)
    {
        Intent one= new Intent(this,viewcourse.class);
        startActivity(one);
    }

    public void viewstaff(View v)
    {
        Intent one=new Intent(this,viewstaff.class);
        startActivity(one);

    }

    public void viewstudent(View v)
    {

        Intent one= new Intent(this,Viewstudent.class);
        startActivity(one);

    }












}





















