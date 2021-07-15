package com.example.ourclimate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GuidanceListActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private List<GuidanceModel> guidanceModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private int currentPage = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidance_list);

        initViews();
        initListeners();


    }


    private void initViews() {
        recyclerView = findViewById(R.id.guidanceRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.progressBar);
    }

    private void initListeners() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(!recyclerView.canScrollVertically(1)){
                    Toast.makeText(GuidanceListActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                    currentPage++;
                    showGuidance();
                }
            }
        });
    }

    private void showGuidance() {
        /*------TO BE FILLED------*/
    }

}