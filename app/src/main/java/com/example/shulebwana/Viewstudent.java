package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.shulebwana.modal.Student;

public class Viewstudent extends AppCompatActivity {


    DatabaseHelper map;

String bbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewstudent);
        map =new DatabaseHelper(this);
     TextView editfname = findViewById(R.id.textView2);
        TextView aaa = findViewById(R.id.textView3);


        Student qqq= map.viewAllStudents();
        editfname.setText(qqq.getFirstname());




        switch(qqq.getPro())
        {
            case "1":
                bbb="BSC IN COMPUTER SCIENCE";
                break;

            case "2":
                bbb="BSC IN COMPUTER ENGINEERING";
                break;
            case "3":
                bbb="BSC IN TELCOM";
                break;
            case"4":
                bbb="BSC IN ELECTRONIC";

        }








        aaa.setText(bbb);















    }
}
