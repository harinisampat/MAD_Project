package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.*;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SelectClothes extends AppCompatActivity {

    ImageButton minus1, minus2, minus3;
    ImageButton plus1, plus2, plus3;
    TextView tv1, tv2, tv3;
    Spinner spin_age, spin_other;
    CheckBox cb_male, cb_female;
    Button btn_next;
    int tshirt_count = 0;
    int pant_count = 0;
    int other_count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_clothes);

        spin_age = findViewById(R.id.spin_age);
        spin_other = findViewById(R.id.spin_other);
        cb_male = findViewById(R.id.cb_male);
        cb_female = findViewById(R.id.cb_female);
        btn_next = findViewById(R.id.btn_next);

        minus1= findViewById(R.id.btn_minus1);
        minus2 = findViewById(R.id.btn_minus2);
        minus3 = findViewById(R.id.btn_minus3);

        plus1 = findViewById(R.id.btn_plus1);
        plus2 = findViewById(R.id.btn_plus2);
        plus3 = findViewById(R.id.btn_plus3);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);

        //Tshirt
        plus1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tshirt_count++;
                tv1.setText("" + tshirt_count);
            }
        });
        minus1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(tshirt_count<1)
                    tshirt_count=0;
                else
                {
                    tshirt_count--;
                    tv1.setText("" + tshirt_count);
                }
            }
        });


        //Pants
        plus2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                pant_count++;
                tv2.setText("" + pant_count);
            }
        });
        minus2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(pant_count<1)
                    pant_count=0;
                else
                {
                    pant_count--;
                    tv2.setText("" + pant_count);
                }
            }
        });


        //Others
        plus3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                other_count++;
                tv3.setText("" + other_count);
            }
        });
        minus3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(other_count<1)
                    other_count=0;
                else
                {
                    other_count--;
                    tv3.setText("" + other_count);
                }
            }
        });

        //Spinner - age group
        ArrayAdapter adapt = ArrayAdapter.createFromResource(this,R.array.agegroup, R.layout.spinner_list);
        adapt.setDropDownViewResource(R.layout.spinner_dropdown);
        spin_age.setAdapter(adapt);

        spin_age.setPrompt("Select age group");

        spin_age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = String.valueOf(spin_age.getSelectedItem());
                if (str.equals("5-12 years")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("13-19 years")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("20-40 years")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("41-65 years")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });

        //Spinner - others
        ArrayAdapter adapt2 = ArrayAdapter.createFromResource(this,R.array.other, R.layout.spinner_list);
        adapt2.setDropDownViewResource(R.layout.spinner_dropdown);
        spin_other.setAdapter(adapt2);

        spin_other.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = String.valueOf(spin_other.getSelectedItem());
                if (str.equals("Blankets")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("Jackets")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("Sarees")) {
                    Toast.makeText(SelectClothes.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                spin_other.setSelection(0);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(SelectClothes.this, DeliverySlot.class);
                startActivity(intent);
            }
        });


    }
}