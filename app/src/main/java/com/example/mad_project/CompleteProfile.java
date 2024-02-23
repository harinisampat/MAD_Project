package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.*;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


import androidx.core.content.ContextCompat;

import java.util.regex.Pattern;

public class CompleteProfile extends AppCompatActivity {

    EditText cp_password;
    EditText cp_username;
    EditText cp_cnfpassword;
    ImageView password_icon;
    ImageView eye_icon;
    Intent my_intent;
    Button btn_signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_profile);

        cp_password = findViewById(R.id.cp_password);
        cp_cnfpassword = findViewById(R.id.cp_cnfpassword);
        password_icon = findViewById(R.id.password_icon);
        btn_signup = findViewById(R.id.btn_signup);
        cp_username = findViewById(R.id.cp_username);
        eye_icon = findViewById(R.id.eye_icon);

        eye_icon.setImageResource(R.drawable.hide_password);
        eye_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cp_password.getTransformationMethod().equals(HideReturnsTransformationMethod.getInstance())) {
                    cp_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    eye_icon.setImageResource(R.drawable.hide_password);
                }
                else {
                    cp_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    eye_icon.setImageResource(R.drawable.show_password);
                }
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (!cp_username.getText().toString().isEmpty() && !cp_password.getText().toString().isEmpty() && !cp_cnfpassword.getText().toString().isEmpty()) {
                    if (cp_password.getText().toString().equals(cp_cnfpassword.getText().toString()))
                    {
                        my_intent = new Intent(CompleteProfile.this, HomePage.class );
                        startActivity(my_intent);
                        Toast.makeText(getApplicationContext(), "SignUp Complete", Toast.LENGTH_SHORT).show();
                    }

                    else
                    {
                        Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(), "Enter valid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });


        cp_password.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                validatePassword(s.toString());
            }
        });

    }

    private void validatePassword(String password)
    {
        boolean isValid = isValidPassword(password);
        Drawable drawable;
        if (isValid)
        {
            drawable = ContextCompat.getDrawable(this, R.drawable.icon_tick); //set green tick drawable
        }
        else
        {
            drawable = ContextCompat.getDrawable(this, R.drawable.ic_error); //set error drawable
        }
        password_icon.setImageDrawable(drawable);
        password_icon.setContentDescription(isValid ? "Password is valid": "Password is invalid");
    }

    private boolean isValidPassword(String password)
    {
        Pattern PASSWORD_PATTERN = Pattern.compile("[a-zA-Z0-9\\!\\@\\#\\$]{8,24}");
        return !TextUtils.isEmpty(password) && PASSWORD_PATTERN.matcher(password).matches();
    }
}