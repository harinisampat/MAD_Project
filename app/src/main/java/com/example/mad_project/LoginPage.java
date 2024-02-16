package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    TextView tv_newuser;
    EditText et_mobile;
    EditText et_pass;
    Button btnlogin;
    Intent homepg_myintent;
    Intent signup_intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        homepg_myintent = new Intent(LoginPage.this, HomePage.class);
        et_mobile = findViewById(R.id.et_mobile);
        et_pass = findViewById(R.id.et_pass);
        btnlogin = findViewById(R.id.btn_login);
        tv_newuser = findViewById(R.id.tv_newuser);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if ( et_mobile.getText().toString().equals("1234567890") && et_pass.getText().toString().equals("pass1"))
                {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    startActivity(homepg_myintent);
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });

        tv_newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                signup_intent = new Intent(LoginPage.this, SignUp.class);
                startActivity(signup_intent);
            }
        });
    }
}