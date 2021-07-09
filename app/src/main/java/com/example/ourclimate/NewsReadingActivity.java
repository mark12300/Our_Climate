package com.example.ourclimate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class NewsReadingActivity extends AppCompatActivity {

    private TextView titleTxt, contentTxt, dateTxt;
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_reading);

        initViews();
        setViews();
    }

    private void setViews() {
        Intent tempIntent = getIntent();
        titleTxt.setText(tempIntent.getStringExtra("Title"));
        contentTxt.setText(tempIntent.getStringExtra("Content"));
        dateTxt.setText("Published Date: " + tempIntent.getStringExtra("Date"));
        Glide.with(this).asBitmap().load(tempIntent.getStringExtra("ImageURL")).into(imgView);
    }

    private void initViews() {
        titleTxt = findViewById(R.id.titleTxt);
        contentTxt = findViewById(R.id.contentTxt);
        dateTxt = findViewById(R.id.dateTxt);
        imgView = findViewById(R.id.imgView);
    }
}