package com.example.ourclimate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewsFeedActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private List<NewsModel> newsModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private boolean isLoading = false;
    private NewsAdapter newsAdapter;
    private int currentPage = 1;
    private final String URL_PART_1 = "https://content.guardianapis.com/search?order-by=newest&section=environment&show-fields=bodyText,thumbnail&q=climate&page=";
    private final String URL_PART_2 = "&page-size=200&api-key=21f720af-057a-4a98-b5db-29886f455a42";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        initViews();
        initListeners();

        retrieveNews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.newsRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.guidelinesProgressBar);
    }

    private void initListeners() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if (!recyclerView.canScrollVertically(1)) {
                    Toast.makeText(NewsFeedActivity.this, "Loading...", Toast.LENGTH_SHORT).show();
                    currentPage++;
                    retrieveNews();
                }
            }
        });
    }


    // TODO: For further updates, we need to reduce the loading time and internet data consumption
    public void retrieveNews() {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL_PART_1 + currentPage + URL_PART_2, null, response -> {

            try {
                JSONObject response2 = response.getJSONObject("response");
                if (response2.getString("status").equals("ok")) {
                    JSONArray newsData = response2.getJSONArray("results");
                    for (int i = 0; i < newsData.length(); i++) {
                        JSONObject tempJsonObj = newsData.getJSONObject(i);
                        JSONObject tempFieldsObj = tempJsonObj.getJSONObject("fields");
                        NewsModel tempNewsModel = new NewsModel(tempJsonObj.getString("webTitle"), tempJsonObj.getString("webPublicationDate").substring(0, 10), tempFieldsObj.getString("thumbnail"), tempFieldsObj.getString("bodyText"));
                        newsModelList.add(tempNewsModel);

                    }

                    if (newsAdapter == null) {
                        newsAdapter = new NewsAdapter(NewsFeedActivity.this, newsModelList, new NewsAdapter.OnItemClickListener() {
                            @Override
                            public void onItemClick(NewsModel item) {
                                Intent intent = new Intent(NewsFeedActivity.this, NewsReadingActivity.class);
                                intent.putExtra("Title", item.getTitle());
                                intent.putExtra("Date", item.getDate());
                                intent.putExtra("ImageURL", item.getImageURL());
                                intent.putExtra("Content", item.getContent());
                                startActivity(intent);
                            }
                        });
                        recyclerView.setAdapter(newsAdapter);
                    } else {
                        newsAdapter.updateNewsModelList(newsModelList);
                    }

                    progressBar.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                    Log.d("Response", response.toString());
                } else {
                    Toast.makeText(getApplicationContext(), "Couldn't get data from the server", Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }, error -> {
            Log.d("Error", error.toString());
            Toast.makeText(NewsFeedActivity.this, error.toString(), Toast.LENGTH_SHORT).show();
        });


        MySingleton.getInstance(NewsFeedActivity.this).addToRequestQueue(jsonObjectRequest);
    }
}