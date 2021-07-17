package com.example.ourclimate;

public class GuidanceModel {
    private String content, title, imageURL;

    public GuidanceModel(String content, String title, String image) {
        this.content = content;
        this.title = title;
        this.imageURL = image;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
