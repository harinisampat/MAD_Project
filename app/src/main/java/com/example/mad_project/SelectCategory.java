package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class SelectCategory extends AppCompatActivity {

    Button btn_next, btn_next2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_category);

        btn_next = findViewById(R.id.btn_next);
        btn_next2 = findViewById(R.id.btn_next2);

        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectCategory.this, SelectFood.class);
                startActivity(intent);
            }
        });

        btn_next2.setOnClickListener(new View.OnClickListener()
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