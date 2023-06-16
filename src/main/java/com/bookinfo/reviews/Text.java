package com.bookinfo.reviews;

public class Text {
    private String reviewer;
    private String text;

    public Text(int productId, String reviewer, String text) {
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
