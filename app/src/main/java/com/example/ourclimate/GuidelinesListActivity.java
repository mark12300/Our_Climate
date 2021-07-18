package com.example.ourclimate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class GuidelinesListActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private List<GuidelineModel> guidelinesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private GuidelineAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guidelines_list);

        initViews();
        initListeners();

        showGuidelines();
        progressBar.setVisibility(View.GONE);
        recyclerView.setVisibility(View.VISIBLE);
    }


    private void initViews() {
        recyclerView = findViewById(R.id.guidelinesRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.guidelinesProgressBar);
    }

    private void initListeners() {
    }

    private void showGuidelines() {
        guidelinesList.add(new GuidelineModel("Flood", "Get to a higher level", "https://amp.insurancejournal.com/app/uploads/2015/04/Flood-house-580x436.jpg"));
        guidelinesList.add(new GuidelineModel("Tornado", "Hold onto something", "https://i0.wp.com/digital-photography-school.com/wp-content/uploads/2015/06/langford-1.jpg?fit=750%2C452&ssl=1"));
        guidelinesList.add(new GuidelineModel("Earthquake", "Hide under a table", "https://i.pinimg.com/originals/df/9b/33/df9b3371fc66d1a6ef3736c089456206.jpg"));

        adapter = new GuidelineAdapter(GuidelinesListActivity.this, guidelinesList, new GuidelineAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(GuidelineModel item) {
                Intent intent = new Intent(GuidelinesListActivity.this, GuidelineReadingActivity.class);
                intent.putExtra("Title", item.getTitle());
                intent.putExtra("ImageURL", item.getImageURL());
                intent.putExtra("Content", item.getContent());
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

}