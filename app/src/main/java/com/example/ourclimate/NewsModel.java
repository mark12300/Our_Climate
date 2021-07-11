package com.example.ourclimate;

public class NewsModel {

    private String title, date, imageURL, content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public NewsModel() {
    }

    public NewsModel(String title, String date, String imageURL, String content) {
        this.title = title;
        this.date = date;
        this.imageURL = imageURL;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String url) {
        this.imageURL = url;
    }
}
