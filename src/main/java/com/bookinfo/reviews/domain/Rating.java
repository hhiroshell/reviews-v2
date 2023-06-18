package com.bookinfo.reviews.domain;

public class Rating {
    private String reviewer;
    private int stars;

    public Rating(String reviewer, int stars) {
        this.reviewer = reviewer;
        this.stars = stars;
    }

    public String getReviewer() {
        return reviewer;
    }

    public int getStars() {
        return stars;
    }
}