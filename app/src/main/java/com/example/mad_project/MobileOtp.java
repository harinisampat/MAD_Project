package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MobileOtp extends AppCompatActivity {

    EditText txt_otp;
    Button btn_verify;
    Intent verify_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_otp);

        btn_verify = findViewById(R.id.btn_verify);
        txt_otp = findViewById(R.id.sg_otp);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (! txt_otp.getText().toString().isEmpty())
                {
                    verify_intent = new Intent(MobileOtp.this, CompleteProfile.class);
                    startActivity(verify_intent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Invalid OTP", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}