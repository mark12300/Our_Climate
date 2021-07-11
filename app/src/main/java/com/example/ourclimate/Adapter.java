package com.example.ourclimate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context context;
    private List<NewsModel> newsModelList;
    private final OnItemClickListener listener;


    public Adapter(Context context, List<NewsModel> newsModelList, OnItemClickListener listener) {
        this.context = context;
        this.newsModelList = newsModelList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
            return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            NewsModel newsModel = newsModelList.get(position);
            holder.newsTitle.setText(newsModel.getTitle());
            holder.newsDate.setText(newsModel.getDate());
            Glide.with(context).asBitmap().load(newsModel.getImageURL()).into(holder.newsImage);
            holder.bind(newsModel, listener);
    }

    @Override
    public int getItemCount() {
        return newsModelList == null ? 0 : newsModelList.size();
    }

    public void updateNewsModelList(List<NewsModel> newsModelList) {
        this.newsModelList = newsModelList;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(NewsModel item);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView newsTitle, newsDate;
        ImageView newsImage;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            initViews(itemView);
        }

        private void initViews(View view) {
            newsTitle = view.findViewById(R.id.newsTitle);
            newsDate = view.findViewById(R.id.newsDate);
            newsImage = view.findViewById(R.id.newsImage);
            cardView = view.findViewById(R.id.newsCard);
        }

        public void bind(final NewsModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
