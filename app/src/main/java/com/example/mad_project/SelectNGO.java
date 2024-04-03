package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;
import android.*;
import java.*;
import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.*;

public class SelectNGO extends AppCompatActivity {

    ImageButton btnngo1, btnngo2, btnngo3, btnngo4, btnngo5, btnngo6, btnngo7, btnngo8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_ngo);

        RecyclerView recyclerView = findViewById(R.id.rv1);
        ArrayList<NgoModel> objectList = new ArrayList<NgoModel>();
        objectList.add(new NgoModel("Udaan India Foundation", R.drawable.udaan,"NGO", "Vikhroli", "9967885468", "udaan.com "));
        objectList.add(new NgoModel("Punarvas Special School", R.drawable.punarvas, "School for Handicap", "Goregaon", "2247491799", "punarvasschool.org"));
        objectList.add(new NgoModel("Yuva Foundation", R.drawable.yuva, "NGO", "Malad", "9004089999", "yuvafoundation.net"));
        objectList.add(new NgoModel("Smile Foundation", R.drawable.smile, "NGO", "Vile Parle", "2226104106", "smilefoundation.com"));
        objectList.add(new NgoModel("BHN Senior Living Center", R.drawable.bhn, "Old Age Home", "Andheri", "7045464010", "bhnhealthcare.com"));
        objectList.add(new NgoModel("St. Anthony Home", R.drawable.stanthony, "Old Age Home", "Bandra", "9000999754", "stanthonyhome.com"));
        objectList.add(new NgoModel("Help Your NGO", R.drawable.helpyourngo, "NGO", "Nariman Point", "2261361223", "helpyourngo.com"));
        objectList.add(new NgoModel("VConnect Foundation", R.drawable.vconnect, "NGO", "Byculla", "9930837793", "vconnectfoundation.org"));

        MyAdapter adapter = new MyAdapter(this, objectList);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);



        btnngo1 = findViewById(R.id.btnngo1);
        btnngo2 = findViewById(R.id.btnngo2);
        btnngo3 = findViewById(R.id.btnngo3);
        btnngo4 = findViewById(R.id.btnngo4);
        btnngo5 = findViewById(R.id.btnngo5);
        btnngo6 = findViewById(R.id.btnngo6);
        btnngo7 = findViewById(R.id.btnngo7);
        btnngo8 = findViewById(R.id.btnngo8);

        btnngo1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo5.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo6.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo7.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });

        btnngo8.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectNGO.this, SelectCategory.class);
                startActivity(intent);
            }
        });
    }
}