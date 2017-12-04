package com.example.sam.whattowear;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WhatToWearActivity extends AppCompatActivity {
    private EditText userNameET;
    private TextView userNameTV;
    private EditText genderET;
    private TextView genderTv;
    private EditText fashionStyleET;
    private TextView fashionStyleTV;

    private Button check;

    private ImageView top;
    private ImageView bottom;

    private double currentTemperature;

    private String gender;
    private String style;

    private ArrayList<Integer> images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_what_to_wear);

        userNameET = (EditText) findViewById(R.id.userNameET);
        userNameTV = (TextView) findViewById(R.id.userNameTV);
        genderET = (EditText) findViewById(R.id.genderET);
        genderTv = (TextView) findViewById(R.id.genderTV);
        fashionStyleET = (EditText) findViewById(R.id.fashionStyleET);
        fashionStyleTV = (TextView) findViewById(R.id.fashionStyleTV);

        check = (Button) findViewById(R.id.check);

        top = (ImageView) findViewById(R.id.top);
        bottom = (ImageView) findViewById(R.id.bottom);

        Bundle bundle = getIntent().getExtras();
        String stringTemperature = bundle.getString("currentTemperature");
        currentTemperature = Double.parseDouble(stringTemperature.substring(0, stringTemperature.length()-1));

        images = new ArrayList<>();
        images.add(R.drawable.femalecheapcoolb);
        images.add(R.drawable.femalecheapcoolt);
        images.add(R.drawable.femalecheapwarmb);
        images.add(R.drawable.femalecheapwarmt);
        images.add(R.drawable.femaleexpensivecoolb);
        images.add(R.drawable.femaleexpensivecoolt);
        images.add(R.drawable.femaleexpensivewarmb);
        images.add(R.drawable.femaleexpensivewarmt);
        images.add(R.drawable.malecheapcoolb);
        images.add(R.drawable.malecheapcoolt);
        images.add(R.drawable.malecheapwarmb);
        images.add(R.drawable.malecheapwarmt);
        images.add(R.drawable.maleexpensivecoolb);
        images.add(R.drawable.maleexpensivecoolt);
        images.add(R.drawable.maleexpensivewarmb);
        images.add(R.drawable.maleexpensivewarmt);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender = genderET.getText().toString();
                style = fashionStyleET.getText().toString();
                if (currentTemperature > 50.0) {
                    if (gender.equalsIgnoreCase("male")) {
                        if (style.equalsIgnoreCase("cheap")) {
                            top.setImageResource(R.drawable.malecheapcoolt);
                            bottom.setImageResource(R.drawable.malecheapcoolb);
                        }
                        else if (style.equalsIgnoreCase("expensive")){
                            top.setImageResource(R.drawable.maleexpensivecoolt);
                            bottom.setImageResource(R.drawable.maleexpensivecoolb);
                        }
                    }
                    else if (gender.equalsIgnoreCase("female")) {
                        if (style.equalsIgnoreCase("cheap")) {
                            top.setImageResource(R.drawable.femalecheapcoolt);
                            bottom.setImageResource(R.drawable.femalecheapcoolb);
                        }
                        else if (style.equalsIgnoreCase("expensive")){
                            top.setImageResource(R.drawable.femaleexpensivecoolt);
                            bottom.setImageResource(R.drawable.femaleexpensivecoolb);
                        }
                    }
                }
                else {
                    if (gender.equalsIgnoreCase("male")) {
                        if (style.equalsIgnoreCase("cheap")) {
                            top.setImageResource(R.drawable.malecheapwarmt);
                            bottom.setImageResource(R.drawable.malecheapwarmb);
                        }
                        else if (style.equalsIgnoreCase("expensive")){
                            top.setImageResource(R.drawable.maleexpensivewarmt);
                            bottom.setImageResource(R.drawable.maleexpensivewarmb);
                        }
                    }
                    else if (gender.equalsIgnoreCase("female")) {
                        if (style.equalsIgnoreCase("cheap")) {
                            top.setImageResource(R.drawable.femalecheapwarmt);
                            bottom.setImageResource(R.drawable.femalecheapwarmb);
                        }
                        else if (style.equalsIgnoreCase("expensive")){
                            top.setImageResource(R.drawable.femaleexpensivewarmt);
                            bottom.setImageResource(R.drawable.femaleexpensivewarmb);
                        }
                    }
                }
            }
        });
    }
}
