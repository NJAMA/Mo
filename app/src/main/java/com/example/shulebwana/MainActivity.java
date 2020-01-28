package com.example.shulebwana;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shulebwana.modal.Login;
import com.example.shulebwana.modal.Student;
import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper my;

    EditText username;
    EditText password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        my = new DatabaseHelper(this);

         username=findViewById(R.id.editText);
         password=findViewById(R.id.editText2);
         login=findViewById(R.id.button1);

onclick();

    }

  public void onclick() {


      login.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {


              Login day = new Login();
              day.setPassword(password.getText().toString());
              day.setUsername(username.getText().toString());
              Login aaaa = my.login(day);

              if (aaaa.getPassword().equals(day.getPassword())&&aaaa.getRole().equals("2")) {

              aaa();
              }


                 else if(aaaa.getRole().equals("1")&&aaaa.getPassword().equals(day.getPassword()))
                  {
                      admin();

                  }

else if (aaaa.getRole().equals("3")&&aaaa.getPassword().equals(day.getPassword())){

           staff();

              }


          }
      });


  }



    public void aaa()
    {
        Intent one= new Intent(this, student.class);
        startActivity(one);

    }


  public void admin()

  {
      Intent one= new Intent(this,Administrator.class);
      startActivity(one);



  }

public void staff()
{
    Intent one= new Intent(this, Staff.class);
    startActivity(one);



}






}
