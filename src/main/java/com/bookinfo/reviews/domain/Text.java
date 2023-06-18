package com.bookinfo.reviews.domain;

public class Text {
    private String reviewer;
    private String text;

    public Text(String reviewer, String text) {
        this.reviewer = reviewer;
        this.text = text;
    }

    public String getReviewer() {
        return reviewer;
    }

    public String getText() {
        return text;
    }
}
