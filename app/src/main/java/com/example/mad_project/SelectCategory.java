package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SelectCategory extends AppCompatActivity {

    Button btn_donfood, btn_doncloth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_category);

        btn_donfood = findViewById(R.id.btn_donfood);
        btn_doncloth = findViewById(R.id.btn_doncloth);

        btn_donfood.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectCategory.this, SelectFood.class);
                startActivity(intent);
            }
        });

        btn_doncloth.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectCategory.this, SelectClothes.class);
                startActivity(intent);
            }
        });
    }
}