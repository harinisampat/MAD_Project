package com.example.mad_project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class DeliverySlot extends AppCompatActivity {

    Button btn_submit;
    EditText donationdate;
    Spinner timeslot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_slot);

        btn_submit = findViewById(R.id.btn_submit);
        donationdate = findViewById(R.id.donationdate);
        timeslot = findViewById(R.id.timeslot);

        donationdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                //Creating variable for date picker and passing context
                DatePickerDialog datePickerDialog = new DatePickerDialog(DeliverySlot.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        //Setting date to edit text
                        donationdate.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                    }
                }, year, month, day); //Passing year, month and day for selected date in date picker
                datePickerDialog.show(); //Display date picker dialog
            }
        });

        //String[] timeslots = getResources().getStringArray(R.array.timeslot);
        ArrayAdapter adapt = ArrayAdapter.createFromResource(this,R.array.timeslot, R.layout.spinner_list);
        adapt.setDropDownViewResource(R.layout.spinner_dropdown);
        timeslot.setAdapter(adapt);

        timeslot.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = String.valueOf(timeslot.getSelectedItem());
                if (str.equals("9AM-12PM")) {
                    Toast.makeText(DeliverySlot.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("12PM-3PM")) {
                    Toast.makeText(DeliverySlot.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
                else if (str.equals("3PM-6PM")) {
                    Toast.makeText(DeliverySlot.this,("You selected " + str), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn_submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(DeliverySlot.this, Confirmation.class);
                startActivity(intent);
            }
        });

    }
}