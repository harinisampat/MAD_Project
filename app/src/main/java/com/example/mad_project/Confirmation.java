package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

public class Confirmation extends AppCompatActivity {

    TextView points;
    TextView donationid;
    TextView delivery;
    ImageView tickgif;
    Button btn_home;
    int tshirt_count, pant_count, other_count;
    int water_count, juice_count, chips_count, biscuit_count;

    String date;
    String time;

    int min = 100;
    int max = 500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);

        tickgif = findViewById(R.id.tickgif);
        btn_home = findViewById(R.id.btn_home);
        points = findViewById(R.id.points);
        donationid = findViewById(R.id.donationid);
        delivery = findViewById(R.id.delivery);

        Random random = new Random();
        int random_number = random.nextInt((max-min) + 1) + min;
        String random_number_str = String.valueOf(random_number);
        donationid.setText("Donation Id: " + random_number_str);

        Glide.with(this).load(R.drawable.tick).into(tickgif);

        tshirt_count = getIntent().getIntExtra("Tshirt",0);
        pant_count = getIntent().getIntExtra("Pant", 0);
        other_count = getIntent().getIntExtra("Other", 0);
        water_count = getIntent().getIntExtra("Water", 0);
        chips_count = getIntent().getIntExtra("Chips", 0);
        juice_count = getIntent().getIntExtra("Juice", 0);
        biscuit_count = getIntent().getIntExtra("Biscuit", 0);
        date = getIntent().getStringExtra("Date");
        time = getIntent().getStringExtra("Time");

        delivery.setText("Your donation will be received on " + date + " between " + time);

        int total_clothes = tshirt_count + pant_count + other_count;
        int total_food = water_count + juice_count + chips_count + biscuit_count;

        if((total_clothes>0 && total_clothes<=5)||(total_food>0 && total_food<=10))
        {
            points.setText("You've earned 10 gratitude points!");
        }
        else if((total_clothes>5 && total_clothes<=10)||(total_food>10 && total_food<=30))
        {
            points.setText("You've earned 20 gratitude points!");
        }
        else
        {
            points.setText("You've earned 50 gratitude points!");
        }

        btn_home.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Confirmation.this, HomePageMap.class);
                startActivity(intent);
            }
        });
    }
}