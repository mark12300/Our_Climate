package com.example.ourclimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class GuidelineReadingActivity extends AppCompatActivity {
    private TextView titleTxt, contentTxt;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideline_reading);

        initViews();
        setViews();
    }

    private void initViews() {
        titleTxt = findViewById(R.id.guidelineTitleTxt);
        contentTxt = findViewById(R.id.guidelineContentTxt);
        imgView = findViewById(R.id.guidelineImg);
    }

    private void setViews() {
        Intent tempIntent = getIntent();
        titleTxt.setText(tempIntent.getStringExtra("Title"));
        contentTxt.setText(tempIntent.getStringExtra("Content"));
        Glide.with(this).asBitmap().load(tempIntent.getStringExtra("ImageURL")).into(imgView);
    }
}