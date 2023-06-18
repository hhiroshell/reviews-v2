package com.bookinfo.reviews.api;

import com.fasterxml.jackson.annotation.JsonCreator;

public class Review {
    private String reviewer;
    private String text;
    private Rating rating;

    @JsonCreator
    public Review(String reviewer, String text, int stars) {
        this.reviewer = reviewer;
        this.text = text;
        this.rating = new Rating(stars);
    }

    public String getReviewer() {
        return this.reviewer;
    }

    public String getText() {
        return this.text;
    }

    public Rating getRating() {
        return this.rating;
    }
}