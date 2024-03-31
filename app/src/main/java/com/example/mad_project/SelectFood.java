package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.*;
import android.widget.ImageButton;
import android.widget.TextView;

public class SelectFood extends AppCompatActivity {

    ImageButton minus1, minus2, minus3, minus4;
    ImageButton plus1, plus2, plus3, plus4;
    TextView tv1, tv2, tv3, tv4;
    Button btn_next;
    int water_count = 0;
    int biscuit_count = 0;
    int juice_count = 0;
    int chips_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_food);

        btn_next = findViewById(R.id.btn_next);

        minus1= findViewById(R.id.btn_minus1);
        minus2 = findViewById(R.id.btn_minus2);
        minus3 = findViewById(R.id.btn_minus3);
        minus4 = findViewById(R.id.btn_minus4);

        plus1 = findViewById(R.id.btn_plus1);
        plus2 = findViewById(R.id.btn_plus2);
        plus3 = findViewById(R.id.btn_plus3);
        plus4 = findViewById(R.id.btn_plus4);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);

        //Water
        plus1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                water_count++;
                tv1.setText("" + water_count);
            }
        });
        minus1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(water_count<1)
                    water_count=0;
                else
                {
                    water_count--;
                    tv1.setText("" + water_count);
                }
            }
        });


        //Biscuit
        plus2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                biscuit_count++;
                tv2.setText("" + biscuit_count);
            }
        });
        minus2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(biscuit_count<1)
                    biscuit_count=0;
                else
                {
                    biscuit_count--;
                    tv2.setText("" + biscuit_count);
                }
            }
        });

        //Juice
        plus3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                juice_count++;
                tv3.setText("" + juice_count);
            }
        });
        minus3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(juice_count<1)
                    juice_count=0;
                else
                {
                    juice_count--;
                    tv3.setText(""  + juice_count);
                }
            }
        });

        //Chips
        plus4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                chips_count++;
                tv4.setText("" + chips_count);
            }
        });
        minus4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(chips_count<1)
                    chips_count=0;
                else
                {
                    chips_count--;
                    tv4.setText("" + chips_count);
                }
            }
        });


        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectFood.this, DeliverySlot.class);
                startActivity(intent);
            }
        });
    }
}