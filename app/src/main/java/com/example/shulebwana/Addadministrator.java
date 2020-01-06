package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Addadministrator extends AppCompatActivity implements View.OnClickListener {

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

        editfname = (EditText) findViewById(R.id.editText3);
        editMname = (EditText) findViewById(R.id.editText7);
        editSname = (EditText) findViewById(R.id.editText14);
        editEmail = (EditText) findViewById(R.id.editText8);
        editphonenumber = (EditText) findViewById(R.id.editText15);
        Birthdate = (EditText) findViewById(R.id.editText5);
        butAdmin = (Button) findViewById(R.id.button11);
        /*butAdmin.setOnClickListener(this);
        regstrAdmin();*/


    }

    public void onClicka(View view) {
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int id = radioGroup.getCheckedRadioButtonId();
        switch (id) {
            case R.id.radioButton:
                geder = "M";
                break;
            case R.id.radioButton2:
                geder = "F";
        }
    }

 /*  public void regstrAdmin() {
       butAdmin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = my.insertdata(editfname.getText().toString(),
                                editMname.getText().toString(), editSname.getText().toString(), editEmail.getText().toString(), Birthdate.getText().toString(), editphonenumber.getText().toString(), geder);


                        if (isInserted == true)
                            Toast.makeText(Addadministrator.this, "Data inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Addadministrator.this, " Data notinserted", Toast.LENGTH_LONG).show();
                    }
                }

        );

    }
*/
    @Override
    public void onClick(View view) {
        boolean isInserted = my.insertdata(editfname.getText().toString(),
                editMname.getText().toString(), editSname.getText().toString(), editEmail.getText().toString(), Birthdate.getText().toString(), editphonenumber.getText().toString(), geder
        );


        if (isInserted == true)
            Toast.makeText(Addadministrator.this, "Data inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(Addadministrator.this, " Data notinserted", Toast.LENGTH_LONG).show();

    }
}


