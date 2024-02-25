package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class MobileOtp extends AppCompatActivity {

    EditText txt_otp, sg_mobile;
    Button btn_verify, btn_getotp;
    Intent verify_intent;
    ImageView otpgif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_otp);

        btn_verify = findViewById(R.id.btn_verify);
        txt_otp = findViewById(R.id.sg_otp);
        sg_mobile = findViewById(R.id.sg_mobile);
        btn_getotp = findViewById(R.id.btn_getotp);
        otpgif = findViewById(R.id.otpgif);

        Glide.with(this).load(R.drawable.otpgif).into(otpgif);

        btn_getotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sg_mobile.getText().toString().isEmpty() && sg_mobile.getText().toString().length()==10){
                    Toast.makeText(getApplicationContext(), "OTP Sent Successfully", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (!sg_mobile.getText().toString().isEmpty() && sg_mobile.getText().toString().length()==10) {
                    if (!txt_otp.getText().toString().isEmpty())
                    {
                        verify_intent = new Intent(MobileOtp.this, CompleteProfile.class);
                        startActivity(verify_intent);
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}