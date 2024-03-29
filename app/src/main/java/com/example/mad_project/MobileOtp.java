package com.example.mad_project;

import android.os.Bundle;
import android.*;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.hbb20.CountryCodePicker;

public class MobileOtp extends AppCompatActivity
{
    EditText sg_mobile;
    Button btn_getotp;
    CountryCodePicker ccp;
    ImageView otpgif;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_otp);

        sg_mobile = findViewById(R.id.sg_mobile);
        btn_getotp = findViewById(R.id.btn_getotp);
        ccp = findViewById(R.id.ccp);
        otpgif = findViewById(R.id.otpgif);

        Glide.with(this).load(R.drawable.otpgif).into(otpgif);

        ccp.registerCarrierNumberEditText(sg_mobile);

        btn_getotp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(!ccp.isValidFullNumber())
                {
                    Toast.makeText(MobileOtp.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent(MobileOtp.this, Otp.class);
                    intent.putExtra("Phone", ccp.getFullNumberWithPlus());
                    startActivity(intent);
                }
            }
        });
    }
}