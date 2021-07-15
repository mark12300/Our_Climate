package com.example.ourclimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GuidanceReading extends AppCompatActivity {
    private TextView titleTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance_reading);

        initViews();
        setViews();
    }

    private void initViews() {
        titleTxt = findViewById(R.id.titleTxt);
        contentTxt = findViewById(R.id.contentTxt);
    }

    private void setViews() {
        Intent tempIntent = getIntent();
        titleTxt.setText(tempIntent.getStringExtra("Title"));
        contentTxt.setText(tempIntent.getStringExtra("Content"));
    }
}