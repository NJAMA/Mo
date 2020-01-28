package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shulebwana.R;
import com.example.shulebwana.modal.Course;
import com.facebook.stetho.Stetho;

import java.util.List;

public class addCourse extends AppCompatActivity {
DatabaseHelper my;
    EditText code, name;
    Spinner year, credits, semister,programme;
    Button save;
    CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);
        Stetho.initializeWithDefaults(this);
        my=new DatabaseHelper(this);

        programme =findViewById(R.id.spinner6);
        code = findViewById(R.id.editText17);
        name = findViewById(R.id.editText4);
        year = findViewById(R.id.spinner9);
        credits = findViewById(R.id.spinner10);
        semister = findViewById(R.id.spinner8);
        save=findViewById(R.id.button111);

        List<String> programmes= my.getProgramme();
        ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,programmes );
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        programme.setAdapter(data);

Clickclick();
        
    }


    public void Clickclick ()
    {

        save.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {


                                        Course a = new Course();
                                        a.setCoursecode(code.getText().toString());
                                        a.setCoursename(name.getText().toString());
                                        a.setCredits(credits.getSelectedItem().toString());
                                        a.setSemister(semister.getSelectedItem().toString());
                                        a.setYearofstudy(year.getSelectedItem().toString());

                                        boolean isInserted = my.insertCourse(a);


                                        if (isInserted ==true)
                                            Toast.makeText(addCourse.this, "Data inserted", Toast.LENGTH_LONG).show();
                                        else
                                            Toast.makeText(addCourse.this, " Data not inserted", Toast.LENGTH_LONG).show();




                                    }
                                }

            );
    }
    
    

    
    
    
    
    
    
}




