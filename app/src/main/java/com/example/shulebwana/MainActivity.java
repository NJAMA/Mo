package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper my;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        my = new DatabaseHelper(this);

    }

  public void onclick(View v)
  {

      Intent aa=new Intent(this,Addadministrator.class);
         startActivity(aa);


  }






}
