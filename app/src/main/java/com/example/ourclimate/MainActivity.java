package com.example.ourclimate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button newsBtn, safetyGuidelinesBtn;
    private String URL1 = "https://content.guardianapis.com/search?show-fields=bodyText&show-tags=contributer&q=climate&page=";
    private String URL2 = "&page-size=200&api-key=21f720af-057a-4a98-b5db-29886f455a42";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    // Initialize the views here
    private void initViews() {
        newsBtn = findViewById(R.id.newsBtn);
        safetyGuidelinesBtn = findViewById(R.id.safetyGuidelinesBtn);
    }


    // Add listeners here
    private void initListeners() {
        newsBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NewsFeedActivity.class));
        });

        safetyGuidelinesBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, GuidelinesListActivity.class));
        });
    }
}