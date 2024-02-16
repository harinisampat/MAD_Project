package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.content.Intent;

public class LaunchPage extends AppCompatActivity {

    private static final long delay = 3000; //3 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launch_page);

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                startActivity(new Intent(LaunchPage.this, LoginPage.class));
                finish();
                //finish current activity to prevent going back to it when back button is pressed
            }
        }, delay);

    }
}