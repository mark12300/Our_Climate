package com.example.ourclimate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        initListeners();
    }

    // initialize the views here
    private void initViews() {
    }

    // add the listeners here
    private void initListeners() {
    }
}