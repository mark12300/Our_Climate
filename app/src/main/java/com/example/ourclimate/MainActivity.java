package com.example.ourclimate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button newsBtn,guidanceBtn;
    private List<NewsModel> articles;
    private List<GuidanceModel> guidance;
    private int currentPage = 1;
    private String URL1 = "https://content.guardianapis.com/search?show-fields=bodyText&show-tags=contributer&q=climate&page=";
    private String URL2 = "&page-size=200&api-key=21f720af-057a-4a98-b5db-29886f455a42";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    // initialize the views here
    private void initViews() {
        newsBtn = findViewById(R.id.newsBtn);
        guidanceBtn = findViewById(R.id.guidanceBtn);
    }


    // add the listeners here
    private void initListeners() {
        newsBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, NewsFeedActivity.class));
        });

        guidanceBtn.setOnClickListener(v ->{
            startActivity(new Intent(MainActivity.this, GuidanceListActivity.class));
        });
    }
}