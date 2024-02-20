package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.*;
import android.view.View;
import android.widget.Button;

public class MobileOtp extends AppCompatActivity {

    Button btn_verify;
    Intent verify_intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobile_otp);

        btn_verify = findViewById(R.id.btn_verify);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify_intent = new Intent(MobileOtp.this, CompleteProfile.class);
                startActivity(verify_intent);
            }
        });
    }
}