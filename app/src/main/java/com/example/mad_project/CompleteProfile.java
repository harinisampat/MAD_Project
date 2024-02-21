package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.drawable.Drawable;
import android.*;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;


import androidx.core.content.ContextCompat;

public class CompleteProfile extends AppCompatActivity {

    EditText cp_password;
    EditText cp_cnfpassword;
    ImageView password_icon;
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

        btn_signup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
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
        String passwordPattern = "^(?=.[A-Za-z])(?=.\\d)(?=.[@$!%?&])[A-Za-z\\d@$!%*?&]{6,}$";
        return password.matches(passwordPattern);
    }

    // Description:
    // ^ = denotes beginning symbol
    //. [] = allows any character before and after the content specified in the bracket (can be digit/alphabet etc) include null
    // (?=.[A-Za-z]) = checks for atleast 1 alphabet
    // (?=.\d) = checks for atleast 1 digit
    // (?=.[@$!%?&]) = check for atleast 1 special character from specified set
    // [A-Za-z\d@$!%*?&]{6,} = checks that field contains atleast 6 characters including alphabet, digit and special character
    // {6, } = minimum character is 6, maximum limit is not specified
    // $ = denotes end of line
}